package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.OfertaAcademicaDAO;
import ec.edu.ups.model.OfertaAcademica;

@Stateless
public class OfertaAcademicaON implements OfertaAcademicaONRemote, OfertaAcademicaONLocal {

	@Inject
	private OfertaAcademicaDAO daoOfertaAcademica;
	
	public void insertar(OfertaAcademica p) throws Exception{
		daoOfertaAcademica.insert(p);
	}
	
	public List<OfertaAcademica> getOfertaAcademicas(){
		
		
		return daoOfertaAcademica.getList();
	}
	
}
