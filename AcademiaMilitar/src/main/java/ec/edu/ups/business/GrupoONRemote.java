package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.Grupo;

@Remote
public interface GrupoONRemote {
	public void insertar(Grupo g) throws Exception;
	
	public List <Grupo> getGrupo();
}
