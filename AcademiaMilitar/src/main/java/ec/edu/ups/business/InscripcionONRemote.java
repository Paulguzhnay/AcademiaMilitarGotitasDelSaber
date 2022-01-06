package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;
import ec.edu.ups.model.Inscripcion;

@Remote
public interface InscripcionONRemote {
	public void insertar(Inscripcion in) throws Exception;
	
	public List <Inscripcion> getInscripcions();
}
