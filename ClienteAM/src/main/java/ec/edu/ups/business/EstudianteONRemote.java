package ec.edu.ups.business;
import java.util.List;


import ec.edu.ups.model.*;

public interface EstudianteONRemote {


	public void insertar(Estudiante est) throws Exception;
	
	public List <Estudiante> getEstudiante();
	
}
