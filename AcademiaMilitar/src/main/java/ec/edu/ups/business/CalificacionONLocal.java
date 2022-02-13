package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;


import ec.edu.ups.model.Calificacion;

@Local
public interface CalificacionONLocal {

	
	public void insertar(Calificacion  cal) throws Exception;
	
	public List <Calificacion> getCalificacion(int nivel, String idEst);
	
}
