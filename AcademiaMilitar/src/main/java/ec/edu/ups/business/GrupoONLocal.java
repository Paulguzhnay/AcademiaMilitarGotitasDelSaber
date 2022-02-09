package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Grupo;

@Local
public interface GrupoONLocal {
	public void insertar(Grupo g) throws Exception;
	
	public List <Grupo> getGrupo();
	public List <Grupo> getGrupo2(int matID);
}
