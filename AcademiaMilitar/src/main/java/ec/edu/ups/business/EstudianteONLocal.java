package ec.edu.ups.business;
import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.*;
@Local
public interface EstudianteONLocal {


	public void insertar(Estudiante est) throws Exception;
	
	public List <Estudiante> getEstudiante();
	public List <Estudiante> getEstudianteCuenta(String cedula);
	
}
