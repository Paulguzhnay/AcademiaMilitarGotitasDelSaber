package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.Inscripcion;

public interface InscripcionONRemote {
	public void insertar(Inscripcion in) throws Exception;
	
	public List <Inscripcion> getInscripcions();
}
