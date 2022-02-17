package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.Persona;

@Named
@ViewScoped
public class estudiantesBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	PersonaONLocal personaOn;
	
	private List<Persona> clientes;
	
	private List<Persona> estudiante;
	
	public List<Persona> getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(List<Persona> estudiante) {
		this.estudiante = estudiante;
	}

	Persona persona = new Persona();
	String cedula;
	
	public estudiantesBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		this.loadCliente();
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void loadDataEditar() {
		Persona p = personaOn.getEstudiante(persona.getCedula());
		persona = p;
	}
	
	public void loadData() {
		if(cedula==null)
			return;
		
		Persona p = personaOn.getEstudiante(cedula);
		persona = p;
	}
	
	public List<Persona> getClientes() {
		return clientes;
	}

	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}

	public String editar(String cedula){
		System.out.println("Holaaaaaaaaaaaaaaaaaaaa"+cedula);
		return "interfazEditar?faces-redirect=true&id="+cedula;
	}
	
	public void loadCliente() {
		this.clientes = personaOn.getPersonas();
	}
	
	public String actualizar(String cedula) {
		personaOn.update(persona);
		return "interfazUsuario?faces-redirect=true&id="+cedula;
	}
}
