package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Docente;

@Local
public interface DocenteONLocal {

	public void insertar(Docente  doc) throws Exception;
	public List <Docente> getDocente();

}
