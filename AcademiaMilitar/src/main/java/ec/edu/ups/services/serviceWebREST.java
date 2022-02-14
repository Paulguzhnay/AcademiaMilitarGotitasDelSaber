package ec.edu.ups.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.business.DocenteONLocal;
import ec.edu.ups.model.Docente;

@Path("docentes")
public class serviceWebREST {
	
	@Inject
	private DocenteONLocal docentesON;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Docente> getDocentes(){
		return docentesON.getDocente();
	}
}
