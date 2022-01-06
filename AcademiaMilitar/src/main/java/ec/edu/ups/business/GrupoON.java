package ec.edu.ups.business;

import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.dao.GrupoDAO;
import ec.edu.ups.model.Grupo;

public class GrupoON implements GrupoONRemote{
	
	@Inject
	private GrupoDAO daoGrupo;
	
	public void insertar(Grupo g) throws Exception  {
		daoGrupo.insert(g);
	}
	
	public List <Grupo> getGrupo(){
		return daoGrupo.getList();
	}
	
}
