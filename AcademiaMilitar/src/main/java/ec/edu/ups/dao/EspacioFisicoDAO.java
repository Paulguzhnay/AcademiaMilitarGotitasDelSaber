package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.EspacioFisico;

@Stateless
public class EspacioFisicoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(EspacioFisico esp) {
		em.persist(esp);
	}
	
	public void update(EspacioFisico  esp) {
		em.merge(esp);
	}
	
	public EspacioFisico  read(int id) {
		EspacioFisico  esp=em.find(EspacioFisico.class, id);
		return(esp);
	}
	
	public void delete(int id) {
		EspacioFisico esp=em.find(EspacioFisico.class, id);
		em.remove(esp);
	}
	
	public List<EspacioFisico> getList(){
		
		List<EspacioFisico> listado= new ArrayList<EspacioFisico>();
		
		String jpql ="SELECT esp FROM EspacioFisico esp";
		Query query=em.createQuery(jpql, EspacioFisico.class);
		listado=query.getResultList();
		
		return listado;
		
	}

}
