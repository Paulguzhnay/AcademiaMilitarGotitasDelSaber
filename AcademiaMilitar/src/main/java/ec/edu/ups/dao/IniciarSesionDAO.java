package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.IniciarSesion;

@Stateless
public class IniciarSesionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(IniciarSesion ins) {
		em.persist(ins);
	}
	
	public void update(IniciarSesion  ins) {
		em.merge(ins);
	}
	
	public IniciarSesion  read(int id) {
		IniciarSesion  ins=em.find(IniciarSesion.class, id);
		return(ins);
	}
	
	public void delete(int id) {
		IniciarSesion ins=em.find(IniciarSesion.class, id);
		em.remove(ins);
	}
	
	public List<IniciarSesion> getList(){
		
		List<IniciarSesion> listado= new ArrayList<IniciarSesion>();
		
		String jpql ="SELECT ins FROM IniciarSesion ins";
		Query query=em.createQuery(jpql, IniciarSesion.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
