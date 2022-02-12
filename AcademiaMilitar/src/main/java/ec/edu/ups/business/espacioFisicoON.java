package ec.edu.ups.business;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.EspacioFisicoDAO;
import ec.edu.ups.model.*;

@Stateless
public class espacioFisicoON implements espacioFisicoONRemote, espacioFisicoONLocal {
	
	@Inject
	private EspacioFisicoDAO daoEspacio;

	public void insertar(EspacioFisico espF) throws Exception  {
		daoEspacio.insert(espF);
	}
	
	public List <EspacioFisico> getEspacioFisico(){
		return daoEspacio.getList();
	}
	
}
