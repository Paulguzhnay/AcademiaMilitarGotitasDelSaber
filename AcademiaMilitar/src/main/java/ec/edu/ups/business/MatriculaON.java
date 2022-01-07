package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.MatriculaDAO;
import ec.edu.ups.model.Matricula;

@Stateless
public class MatriculaON implements MatriculaONRemote, MatriculaONLocal {

	@Inject
	private MatriculaDAO daoMatricula;
	
	public void insertar(Matricula p) throws Exception{
		daoMatricula.insert(p);
	}
	
	public List<Matricula> getMatriculas(){
		
		
		return daoMatricula.getList();
	}
	
}
