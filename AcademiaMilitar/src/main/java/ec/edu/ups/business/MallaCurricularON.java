package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.dao.MallaCurricularDAO;

import ec.edu.ups.model.MallaCurricular;

@Stateless
public class MallaCurricularON implements MallaCurricularONLocal,MallaCurricularONRemote{

	@Inject
	private MallaCurricularDAO daoMalla;
	
	public void insertar(MallaCurricular mall) throws Exception  {
		daoMalla.insert(mall);
	}
	
	public List <MallaCurricular> getLibro(){
		return daoMalla.getList();
	}
}
