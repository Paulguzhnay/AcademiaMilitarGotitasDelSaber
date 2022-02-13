package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Calificacion;

@Stateless
public class CalificacionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Calificacion ca) {
		em.persist(ca);
	}
	
	public void update(Calificacion  ca) {
		em.merge(ca);
	}
	
	public Calificacion  read(int id) {
		Calificacion  ca=em.find(Calificacion.class, id);
		return(ca);
	}
	
	public void delete(int id) {
		Calificacion ca=em.find(Calificacion.class, id);
		em.remove(ca);
	}
	
	public List<Calificacion> getList(int idNivel, String idEst){
		
		List<Calificacion> listado= new ArrayList<Calificacion>();
		
		String jpql ="SELECT ca FROM Calificacion ca  WHERE ca.materia.nivel=?1 AND ca.estudiante.persona.cedula =?2  ";
		Query query=em.createQuery(jpql, Calificacion.class);
		query.setParameter(1, idNivel);
		query.setParameter(2, idEst);
		listado=query.getResultList();
		
		return listado;
		
	}

}
