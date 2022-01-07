package ec.edu.ups.business;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.EstudianteDAO;
import ec.edu.ups.model.*;

@Stateless
public class EstudianteON implements EstudianteONRemote {

	
	@Inject
	private EstudianteDAO daoEstudiante;

	public void insertar(Estudiante est) throws Exception  {
		daoEstudiante.insert(est);
	}
	
	public List <Estudiante> getEstudiante(){
		return daoEstudiante.getList();
	}
	
}
