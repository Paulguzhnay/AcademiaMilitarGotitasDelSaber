package ec.edu.ups.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Persona;

@Named
@RequestScoped	
public class EstudianteBean {
	
	@Inject
	PersonaONLocal personaOn;
	
	private Persona persona = new Persona();
	
	public String editar(String cedula){
		System.out.println(cedula);
		return "VentanaDatos?faces-redirect=true&id="+cedula;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
