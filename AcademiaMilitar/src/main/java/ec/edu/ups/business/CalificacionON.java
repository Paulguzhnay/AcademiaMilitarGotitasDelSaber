package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.model.*;
import ec.edu.ups.dao.*;

@Stateless
public class CalificacionON  implements CalificacionONRemote,CalificacionONLocal{


	
	@Inject
	private CalificacionDAO daoCalificacion;
	


	public void insertar(Calificacion  cal) throws Exception  {
		daoCalificacion.insert(cal);
	}
	
	public List <Calificacion> getCalificacion(){
		return daoCalificacion.getList();
	}
	

}
