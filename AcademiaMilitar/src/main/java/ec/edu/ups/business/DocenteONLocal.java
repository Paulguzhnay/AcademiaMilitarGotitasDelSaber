package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Docente;
import ec.edu.ups.model.Persona;

@Local
public interface DocenteONLocal {

	public void insertar(Docente  doc) throws Exception;
	public List <Docente> getDocente();
	public Docente getDocentes(int id);
}
