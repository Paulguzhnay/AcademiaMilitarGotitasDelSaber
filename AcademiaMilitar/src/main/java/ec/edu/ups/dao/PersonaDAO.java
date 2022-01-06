package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Persona;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona per) {
		em.persist(per);
	}
	
	public void update(Persona  per) {
		em.merge(per);
	}
	
	public Persona  read(int id) {
		Persona  per=em.find(Persona.class, id);
		return(per);
	}
	
	public void delete(int id) {
		Persona per=em.find(Persona.class, id);
		em.remove(per);
	}
	
	public List<Persona> getList(){
		
		List<Persona> listado= new ArrayList<Persona>();
		
		String jpql ="SELECT per FROM Persona per";
		Query query=em.createQuery(jpql, Persona.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
