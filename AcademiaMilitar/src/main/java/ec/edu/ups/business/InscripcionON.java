package ec.edu.ups.business;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.InscripcionDAO;
import ec.edu.ups.model.IniciarSesion;
import ec.edu.ups.model.Inscripcion;


@Stateless
public class InscripcionON implements InscripcionONLocal, InscripcionONRemote{
	@Inject
	private InscripcionDAO daoInscripcion;
	
	public void insertar(Inscripcion in){
		in.setFechaRegistro(new Date());
		daoInscripcion.insert(in);
	}
	
	public List <Inscripcion> getInscripcions(){
		return daoInscripcion.getList();
	}
	public void guardar(Inscripcion p) throws Exception {
		if(daoInscripcion.read(p.getId())==null)
			daoInscripcion.insert(p);
		else
			daoInscripcion.update(p);
	}
	
}
