package ec.edu.ups.business;

import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.dao.InscripcionDAO;

import ec.edu.ups.model.Inscripcion;

public class InscripcionON implements InscripcionONLocal, InscripcionONRemote{
	@Inject
	private InscripcionDAO daoInscripcion;
	
	public void insertar(Inscripcion in) throws Exception  {
		daoInscripcion.insert(in);
	}
	
	public List <Inscripcion> getInscripcions(){
		return daoInscripcion.getList();
	}
}
