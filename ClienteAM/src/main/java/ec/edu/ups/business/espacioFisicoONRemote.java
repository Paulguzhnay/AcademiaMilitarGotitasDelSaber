package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.EspacioFisico;

public interface espacioFisicoONRemote {

	public void insertar(EspacioFisico espF) throws Exception  ;
	
	public List <EspacioFisico> getEspacioFisico();
}
