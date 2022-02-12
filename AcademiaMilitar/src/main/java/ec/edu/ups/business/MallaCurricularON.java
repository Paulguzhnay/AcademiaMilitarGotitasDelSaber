package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.dao.MallaCurricularDAO;

import ec.edu.ups.model.MallaCurricular;



@Stateless
public class MallaCurricularON implements MallaCurricularONLocal,  MallaCurricularONRemote{

	@Inject
	private MallaCurricularDAO daoMalla;
	
	public void insertar(MallaCurricular mall) throws Exception  {
		daoMalla.insert(mall);
	}
	
	public void guardar(MallaCurricular mall) throws Exception  {
		if(daoMalla.read(mall.getId())==null) {
			System.out.println("dao recibe"+daoMalla.read(mall.getId()));
			daoMalla.insert(mall);			
		}
		else {
			daoMalla.update(mall);			
		}
	}
	
	public List <MallaCurricular> getMalla(){
		return daoMalla.getList();
	}
	
	public MallaCurricular obtenerDatosAsignatura(int id) {
		System.out.println("***************************************************************************************************");
		System.out.println("ESTE ES EL ID "+id);
		return daoMalla.read(id);
		
	}
	public MallaCurricular obtenerDatosAsignatura2(int id) {
		System.out.println("***************************************************************************************************");
		System.out.println("ESTE ES EL ID "+id);
		return daoMalla.read2(id);
	}
	
	public void eliminarAsignatura(int id) {
		daoMalla.delete(id);
	}
	////////////////////////////////////////////
	
	/*public void actualizarAsignatura(MallaCurricular mall) {
		daoMalla.update(mall);
	}*/
	////////////////////////////////////////


}
