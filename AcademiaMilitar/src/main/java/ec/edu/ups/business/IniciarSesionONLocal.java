package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;
import ec.edu.ups.model.IniciarSesion;

@Local
public interface IniciarSesionONLocal {

	
	public void insertar(IniciarSesion in) throws Exception;
	
	
	public List <IniciarSesion> getIniciarSesion();
	
	
	public void cambiarContrasenia(IniciarSesion i);
		
		
	
}
