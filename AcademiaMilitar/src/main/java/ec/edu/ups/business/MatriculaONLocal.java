package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Matricula;

@Local
public interface MatriculaONLocal {
	
public void insertar(Matricula p) throws Exception;
	
	public List<Matricula> getMatriculas();
	
	public List<Matricula> getMatFact(int idEst);
	public List<Matricula> getMatHorario(String idEst);
}

