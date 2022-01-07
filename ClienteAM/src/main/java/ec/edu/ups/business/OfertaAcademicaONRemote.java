package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.OfertaAcademica;

public interface OfertaAcademicaONRemote {

public void insertar(OfertaAcademica p) throws Exception;
	
	public List<OfertaAcademica> getOfertaAcademicas();
	
}
