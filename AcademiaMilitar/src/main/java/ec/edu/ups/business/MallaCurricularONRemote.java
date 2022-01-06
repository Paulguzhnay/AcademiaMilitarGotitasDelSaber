package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.MallaCurricular;

@Remote
public interface MallaCurricularONRemote {
	public void insertar(MallaCurricular mall) throws Exception ;
	
	public List <MallaCurricular> getLibro();
}
