package ec.edu.ups.business;
import java.util.List;


import javax.ejb.Remote;

import ec.edu.ups.model.*;
@Remote
public interface EstudianteONRemote {


	public void insertar(Estudiante est) throws Exception;
	
	public List <Estudiante> getEstudiante();
	public Estudiante buscar(int cedula);
}
