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
		
		String jpql ="SELECT mat FROM Materia mat";
		Query query=em.createQuery(jpql, Materia.class);
		listado=query.getResultList();
		
		return listado;
		
	}
	
public List<Materia> getListMaterias(int nivel, int ofeID){
		
		System.out.println(nivel);
		List<Materia> listado= new ArrayList<Materia>();
		
		String jpql ="SELECT mat FROM Materia mat WHERE mat.nivel= ?1 AND mat.ofertaAcademica.id= ?2";
		
		Query query=em.createQuery(jpql, Materia.class);
		query.setParameter(1, nivel);
		query.setParameter(2, ofeID );
		listado=query.getResultList();
		
		return listado;
		
	}

}
