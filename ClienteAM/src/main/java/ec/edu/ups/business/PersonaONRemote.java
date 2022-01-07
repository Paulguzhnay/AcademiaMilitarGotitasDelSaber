package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.Persona;

public interface PersonaONRemote {

public void insertar(Persona p) throws Exception;
	
	public List<Persona> getPersonas();
	
}
