package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.MallaCurricular;

public interface MallaCurricularONRemote {
	public void insertar(MallaCurricular mall) throws Exception ;
	
	public List <MallaCurricular> getLibro();
}
