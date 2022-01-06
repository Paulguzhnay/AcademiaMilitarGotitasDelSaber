package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.OfertaAcademica;

@Remote
public interface OfertaAcademicaONRemote {

public void insertar(OfertaAcademica p) throws Exception;
	
	public List<OfertaAcademica> getOfertaAcademicas();
	
}
