package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Horario;

@Stateless
public class HorarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Horario hor) {
		em.persist(hor);
	}
	
	public void update(Horario  hor) {
		em.merge(hor);
	}
	
	public Horario  read(int id) {
		Horario  hor=em.find(Horario.class, id);
		return(hor);
	}
	
	public void delete(int id) {
		Horario hor=em.find(Horario.class, id);
		em.remove(hor);
	}
	
	public List<Horario> getList(){
		
		List<Horario> listado= new ArrayList<Horario>();
		
		String jpql ="SELECT hor FROM Horario hor";
		Query query=em.createQuery(jpql, Horario.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
