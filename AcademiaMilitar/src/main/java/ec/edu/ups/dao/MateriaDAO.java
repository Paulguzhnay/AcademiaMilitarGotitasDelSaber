package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Materia;

@Stateless
public class MateriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Materia mat) {
		em.persist(mat);
	}
	
	public void update(Materia  mat) {
		em.merge(mat);
	}
	
	public Materia  read(int id) {
		Materia  mat=em.find(Materia.class, id);
		return(mat);
	}
	
	public void delete(int id) {
		Materia mat=em.find(Materia.class, id);
		em.remove(mat);
	}
	
	public List<Materia> getList(){
		
		List<Materia> listado= new ArrayList<Materia>();
		
		String jpql ="SELECT mat FROM Materia mat ORDER by 1";
		Query query=em.createQuery(jpql, Materia.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
