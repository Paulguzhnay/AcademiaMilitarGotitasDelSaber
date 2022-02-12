package ec.edu.ups.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.model.Persona;

@Stateless
public class PersonaON implements PersonaONRemote, PersonaONLocal {

	@Inject
	private PersonaDAO daoPersona;
	
	public void insertar(Persona p){
		daoPersona.insert(p);
	}
	
	public List<Persona> getPersonas(){
		return daoPersona.getList();
	}
	
	public Persona getEstudiante(String cedula) {
		return daoPersona.read(cedula);
	}
	
	public List<Persona> getEstudiantes(String cedula) {
		List<Persona> result = new ArrayList<Persona>();
		result.add(daoPersona.read(cedula));
		return result;
	}
}
