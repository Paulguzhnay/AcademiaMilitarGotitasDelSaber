package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.EspacioFisico;

@Local
public interface espacioFisicoONLocal {

	public void insertar(EspacioFisico espF) throws Exception  ;
	
	public List <EspacioFisico> getEspacioFisico();
}
