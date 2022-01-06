package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.EspacioFisico;

@Remote
public interface espacioFisicoONRemote {

	public void insertar(EspacioFisico espF) throws Exception  ;
	
	public List <EspacioFisico> getEspacioFisico();
}
