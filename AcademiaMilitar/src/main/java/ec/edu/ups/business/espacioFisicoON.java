package ec.edu.ups.business;
import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.dao.EspacioFisicoDAO;
import ec.edu.ups.model.*;

public class espacioFisicoON implements espacioFisicoONRemote {
	
	@Inject
	private EspacioFisicoDAO daoEspacio;

	public void insertar(EspacioFisico espF) throws Exception  {
		daoEspacio.insert(espF);
	}
	
	public List <EspacioFisico> getEspacioFisico(){
		return daoEspacio.getList();
	}
	
}
