package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.MallaCurricular;
@Remote
public interface MallaCurricularONRemote {
	public void insertar(MallaCurricular mall) throws Exception ;
	
	public List <MallaCurricular> getMalla();
	public MallaCurricular obtenerDatosAsignatura(int id);
	public MallaCurricular obtenerDatosAsignatura2(int id);
	public void guardar(MallaCurricular mall) throws Exception ;
	public void eliminarAsignatura(int id);
	//public void actualizarAsignatura(MallaCurricular mall);
}
