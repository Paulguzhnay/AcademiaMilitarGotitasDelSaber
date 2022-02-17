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
public class PrincipalBean implements Serializable {
	
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
	
	public PrincipalBean() {
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
		System.out.println(this.persona.getCedula());
		System.out.println("Holaaaaaaaaaaaaaaaaaaaa"+cedula);
		return "interfazEditar?faces-redirect=true&id="+cedula;
	}
	
	public void loadCliente() {
		this.clientes = personaOn.getPersonas();
	}
	public String editarDatos(String cedula) {
		return "editarEstudiante?faces-redirect=true&id="+cedula;
	}
	
	public String ventanaMatricula(String cedula) {
		return "matriculaDatos.xhtml?faces-redirect=true&id="+cedula;
	}
	public String actualizar() {
		personaOn.update(this.persona);
		return "editarEstudiante?faces-redirect=true&id="+this.persona.getCedula();
	}
	
	//
	public String consultaNotas(String cedula) {
		return "CalificacionesEstudiante2?faces-redirect=true&id="+cedula;
		
	}

	public String horario(String cedula) {
		return "horarioEstudiante.xhtml?faces-redirect=true&id="+cedula;
		
	}
	
	//
	public String inscripcion() {
		return "VentanaInscripciones?faces-redirect=true";
	}
	public String docentes() {
		return "VentanaDocentes?faces-redirect=true";
	}

	public String iniciarSesion() {
		return "VentanaIniciarSesion?faces-redirect=true";
	}
	
	public String ventanaInicio(String cedula) {
		return "interfazUsuario?faces-redirect=true&id="+cedula;
	}
	public String ventanaCuentas(String cedula) {
		return "estudianteCuentas?faces-redirect=true&id="+cedula;
	}
	
	public String ventanaReporte() {
		return "LibroDiario?faces-redirect=true";

	}
	public String ventanaMateria() {
		return "Asignatura?faces-redirect=true";

	}
	public String ventanaOferta() {
		return "VentanaOfertaAcademica?faces-redirect=true";

	}
	
}
