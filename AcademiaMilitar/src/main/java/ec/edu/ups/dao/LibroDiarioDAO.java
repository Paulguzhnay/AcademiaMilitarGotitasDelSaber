package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.LibroDiario;

@Stateless
public class LibroDiarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(LibroDiario lib) {
		em.persist(lib);
	}
	
	public void update(LibroDiario  lib) {
		em.merge(lib);
	}
	
	public LibroDiario  read(int id) {
		LibroDiario  lib=em.find(LibroDiario.class, id);
		return(lib);
	}
	
	public void delete(int id) {
		LibroDiario lib=em.find(LibroDiario.class, id);
		em.remove(lib);
	}
	
	public List<LibroDiario> getList(){
		
		List<LibroDiario> listado= new ArrayList<LibroDiario>();
		
		String jpql ="SELECT lib FROM LibroDiario lib";
		Query query=em.createQuery(jpql, LibroDiario.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
