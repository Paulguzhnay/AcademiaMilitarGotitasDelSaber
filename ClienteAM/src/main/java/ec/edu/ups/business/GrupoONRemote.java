package ec.edu.ups.business;

import java.util.List;
import ec.edu.ups.model.Grupo;

public interface GrupoONRemote {
	public void insertar(Grupo g) throws Exception;
	
	public List <Grupo> getGrupo();
}
