package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;
import ec.edu.ups.model.IniciarSesion;

@Remote
public interface IniciarSesionONRemote {

	
	public void insertar(IniciarSesion in) throws Exception;
	
	public List <IniciarSesion> getHorario();
}
