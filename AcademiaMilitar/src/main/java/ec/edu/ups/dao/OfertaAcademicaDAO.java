package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.OfertaAcademica;

@Stateless
public class OfertaAcademicaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(OfertaAcademica ofe) {
		em.persist(ofe);
	}
	
	public void update(OfertaAcademica  ofe) {
		em.merge(ofe);
	}
	
	public OfertaAcademica  read(int id) {
		OfertaAcademica  ofe=em.find(OfertaAcademica.class, id);
		return(ofe);
	}
	
	public void delete(int id) {
		OfertaAcademica ofe=em.find(OfertaAcademica.class, id);
		em.remove(ofe);
	}
	
	public List<OfertaAcademica> getList(){
		
		List<OfertaAcademica> listado= new ArrayList<OfertaAcademica>();
		
		String jpql ="SELECT ofe FROM OfertaAcademica ofe";
		Query query=em.createQuery(jpql, OfertaAcademica.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
