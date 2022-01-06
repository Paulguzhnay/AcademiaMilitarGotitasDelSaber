package ec.edu.ups.business;

import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.model.*;
import ec.edu.ups.dao.*;


public class CalificacionON  implements CalificacionONRemote{


	
	@Inject
	private CalificacionDAO daoCalificacion;

	public void insertar(Calificacion  cal) throws Exception  {
		daoCalificacion.insert(cal);
	}
	
	public List <Calificacion> getCalificacion(){
		return daoCalificacion.getList();
	}
	

}
