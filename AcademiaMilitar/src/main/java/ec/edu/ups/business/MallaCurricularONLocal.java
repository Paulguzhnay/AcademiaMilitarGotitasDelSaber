package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.MallaCurricular;

@Local
public interface MallaCurricularONLocal {
	public void insertar(MallaCurricular mall) throws Exception ;
	
	public List <MallaCurricular> getLibro();
}
