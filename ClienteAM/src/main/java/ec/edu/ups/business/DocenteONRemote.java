package ec.edu.ups.business;

import java.util.List;


import ec.edu.ups.model.Docente;

public interface DocenteONRemote {

	public void insertar(Docente  doc) throws Exception;
	public List <Docente> getDocente();

}
