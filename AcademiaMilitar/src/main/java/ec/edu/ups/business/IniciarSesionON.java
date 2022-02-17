package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.*;
import ec.edu.ups.model.*;

@Stateless
public class IniciarSesionON implements IniciarSesionONLocal,IniciarSesionONRemote {
	@Inject
	private IniciarSesionDAO daoSesion;
	
	public void insertar(IniciarSesion in) throws Exception  {
		daoSesion.insert(in);
	}
	
	public List <IniciarSesion> getIniciarSesion(){
		return daoSesion.getList();
	}
	
	public void cambiarContrasenia(IniciarSesion i) {
		if(daoSesion.read(i.getId())==null)	
			System.out.println("No hay usuario");
		else 
			daoSesion.update(i);
		
		
	}
}
