package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.MatriculaMaterias;
import ec.edu.ups.model.MatriculaMaterias;

@Stateless
public class MatriculaMateriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(MatriculaMaterias mat) {
		em.persist(mat);
	}
	
	public void update(MatriculaMaterias  mat) {
		em.merge(mat);
	}
	
	public MatriculaMaterias  read(int id) {
		MatriculaMaterias  mat=em.find(MatriculaMaterias.class, id);
		return(mat);
	}
	
	public void delete(int id) {
		MatriculaMaterias mat=em.find(MatriculaMaterias.class, id);
		em.remove(mat);
	}
	
	public List<MatriculaMaterias> getList(){
		
		List<MatriculaMaterias> listado= new ArrayList<MatriculaMaterias>();
		
		String jpql ="SELECT mat FROM MatriculaMaterias mat";
		Query query=em.createQuery(jpql, MatriculaMaterias.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
