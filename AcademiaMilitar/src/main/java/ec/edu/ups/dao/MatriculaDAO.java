package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Matricula;

@Stateless
public class MatriculaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Matricula mat) {
		em.persist(mat);
	}
	
	public void update(Matricula  mat) {
		em.merge(mat);
	}
	
	public Matricula  read(int id) {
		Matricula  mat=em.find(Matricula.class, id);
		return(mat);
	}
	
	public void delete(int id) {
		Matricula mat=em.find(Matricula.class, id);
		em.remove(mat);
	}
	
	public List<Matricula> getList(){
		
		List<Matricula> listado= new ArrayList<Matricula>();
		
		String jpql ="SELECT mat FROM Matricula mat";
		Query query=em.createQuery(jpql, Matricula.class);
		listado=query.getResultList();
		
		return listado;
		
	}
	
	public List<Matricula> getMatFacturas(int idEst){
		
		List<Matricula> listado= new ArrayList<Matricula>();
		
		String jpql ="SELECT mat FROM Matricula mat WHERE mat.estudiante.id=?1";
		Query query=em.createQuery(jpql, Matricula.class);
		query.setParameter(1, idEst);
		listado=query.getResultList();
		
		return listado;
		
	}

	
	public List<Matricula> getMatHorario(String idEst){
		
		List<Matricula> listado= new ArrayList<Matricula>();
		System.out.println(idEst);
		
		String jpql ="SELECT mat FROM Matricula mat WHERE mat.estudiante.persona.cedula=?1";
		Query query=em.createQuery(jpql, Matricula.class);
		query.setParameter(1, idEst);
		
		listado = query.getResultList();

		return listado;
		
	}
}
