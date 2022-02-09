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
	
	public List <IniciarSesion> getHorario(){
		return daoSesion.getList();
	}
}
