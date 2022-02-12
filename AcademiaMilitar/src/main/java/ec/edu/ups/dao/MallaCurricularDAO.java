package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.MallaCurricular;

@Stateless
public class MallaCurricularDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(MallaCurricular mall) {
		em.persist(mall);
	}
	
	public void update(MallaCurricular  mall) {
		em.merge(mall);
	}
	
	public MallaCurricular  read(int id) {
		System.out.println("DAO ID "+id);
		MallaCurricular  mall=em.find(MallaCurricular.class, id);
		return(mall);
	}

	
	public MallaCurricular  read2(int id) {
		System.out.println("DAO ASIGNATURA "+id);
		MallaCurricular  mall=em.find(MallaCurricular.class, id);
		return(mall);
	}
	
	
	public void delete(int id) {
		System.out.println("ID DELETE"+id);
		MallaCurricular mall=em.find(MallaCurricular.class, id);
		em.remove(mall);
	}
	
	public List<MallaCurricular> getList(){
		
		List<MallaCurricular> listado= new ArrayList<MallaCurricular>();
		
		String jpql ="SELECT mall FROM MallaCurricular mall";
		Query query=em.createQuery(jpql, MallaCurricular.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
