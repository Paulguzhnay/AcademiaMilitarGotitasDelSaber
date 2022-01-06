package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Grupo;

@Stateless
public class GrupoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Grupo gru) {
		em.persist(gru);
	}
	
	public void update(Grupo  gru) {
		em.merge(gru);
	}
	
	public Grupo  read(int id) {
		Grupo  gru=em.find(Grupo.class, id);
		return(gru);
	}
	
	public void delete(int id) {
		Grupo gru=em.find(Grupo.class, id);
		em.remove(gru);
	}
	
	public List<Grupo> getList(){
		
		List<Grupo> listado= new ArrayList<Grupo>();
		
		String jpql ="SELECT gru FROM Grupo gru";
		Query query=em.createQuery(jpql, Grupo.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
