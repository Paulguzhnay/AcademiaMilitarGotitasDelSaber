package ec.edu.ups.business;

import java.util.List;


import ec.edu.ups.model.Calificacion;

public interface CalificacionONRemote {

	
	public void insertar(Calificacion  cal) throws Exception;
	
	public List <Calificacion> getCalificacion();
	
}
