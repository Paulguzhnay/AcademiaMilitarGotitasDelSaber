package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.OfertaAcademica;

@Local
public interface OfertaAcademicaONLocal {
	
public void insertar(OfertaAcademica p) throws Exception;
	
	public List<OfertaAcademica> getOfertaAcademicas();

}

