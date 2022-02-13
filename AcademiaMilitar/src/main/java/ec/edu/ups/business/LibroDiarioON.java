package ec.edu.ups.business;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.dao.LibroDiarioDAO;
import ec.edu.ups.model.LibroDiario;

@Stateless
public class LibroDiarioON implements LibroDiarioONLocal, LibroDiarioONRemote{
	@Inject
	private LibroDiarioDAO daoLibro;
	
	public void insertar(LibroDiario lib) throws Exception  {
		daoLibro.insert(lib);
	}
	
	public List <LibroDiario> getLibro(){
		return daoLibro.getList();
	}

}
