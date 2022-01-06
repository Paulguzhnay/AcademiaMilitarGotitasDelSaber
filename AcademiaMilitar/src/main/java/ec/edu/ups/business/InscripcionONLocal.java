package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Inscripcion;

@Local
public interface InscripcionONLocal {
	public void insertar(Inscripcion in) throws Exception;
	
	public List <Inscripcion> getInscripcions();
}
