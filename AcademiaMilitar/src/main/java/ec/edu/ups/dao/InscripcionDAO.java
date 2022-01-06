package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Inscripcion;

@Stateless
public class InscripcionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Inscripcion ins) {
		em.persist(ins);
	}
	
	public void update(Inscripcion  ins) {
		em.merge(ins);
	}
	
	public Inscripcion  read(int id) {
		Inscripcion  ins=em.find(Inscripcion.class, id);
		return(ins);
	}
	
	public void delete(int id) {
		Inscripcion ins=em.find(Inscripcion.class, id);
		em.remove(ins);
	}
	
	public List<Inscripcion> getList(){
		
		List<Inscripcion> listado= new ArrayList<Inscripcion>();
		
		String jpql ="SELECT ins FROM Inscripcion ins";
		Query query=em.createQuery(jpql, Inscripcion.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
