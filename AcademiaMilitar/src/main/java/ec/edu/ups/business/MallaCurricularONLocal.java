package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.MallaCurricular;

@Local
public interface MallaCurricularONLocal {
	public void insertar(MallaCurricular mall) throws Exception ;
	
	public List <MallaCurricular> getMalla();
	public MallaCurricular obtenerDatosAsignatura(int id);
	public void guardar(MallaCurricular mall) throws Exception ;
	public void eliminarAsignatura(int id);
//	public void actualizarAsignatura(MallaCurricular mall);
}
