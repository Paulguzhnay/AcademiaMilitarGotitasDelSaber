package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.Calificacion;

@Remote
public interface CalificacionONRemote {

	
	public void insertar(Calificacion  cal) throws Exception;
	
	public List <Calificacion> getCalificacion(int nivel, String idEst);
	
}
