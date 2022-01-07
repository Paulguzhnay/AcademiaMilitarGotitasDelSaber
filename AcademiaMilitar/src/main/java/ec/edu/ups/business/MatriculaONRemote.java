package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.Matricula;

@Remote
public interface MatriculaONRemote {

public void insertar(Matricula p) throws Exception;
	
	public List<Matricula> getMatriculas();
	
}
