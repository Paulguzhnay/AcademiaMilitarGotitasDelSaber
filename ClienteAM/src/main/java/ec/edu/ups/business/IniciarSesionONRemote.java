package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.IniciarSesion;

public interface IniciarSesionONRemote {

	
	public void insertar(IniciarSesion in) throws Exception;
	
	public List <IniciarSesion> getHorario();
}
