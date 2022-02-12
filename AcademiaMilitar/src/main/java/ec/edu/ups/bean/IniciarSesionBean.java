package ec.edu.ups.bean;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.IniciarSesionON;
import ec.edu.ups.business.IniciarSesionONLocal;
import ec.edu.ups.business.InscripcionONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.IniciarSesion;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Persona;


@Named
@RequestScoped
public class IniciarSesionBean {
	
	@Inject
	private IniciarSesionONLocal iniciarSesionLocal;
			
	private IniciarSesion iniciarSesion = new IniciarSesion();
	
	private List<IniciarSesion> lista;
	
	private String cedula;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public IniciarSesion getIniciarSesion() {
		return iniciarSesion;
	}

	public void setIniciarSesion(IniciarSesion iniciarSesion) {
		this.iniciarSesion = iniciarSesion;
	}

	@PostConstruct
	public void init() {
		this.loadIniciarSesion();
	}

	public List<IniciarSesion> getLista() {
		return lista;
	}

	public void setLista(List<IniciarSesion> lista) {
		this.lista = lista;
	}

	public String iniciarSesion() {
		loadIniciarSesion();
		for (int i=0; i<this.lista.size();i++) {
			if(iniciarSesion.getUsuario().equals(this.lista.get(i).getUsuario())){
				if(iniciarSesion.getContrasenia().equals(this.lista.get(i).getContrasenia())){
					System.out.println("Inicio Sesión");
					return "VentanaPrincipal?faces-redirect=true&id="+lista.get(i).getInscripcion().getPersona().getCedula();
				}else {
					System.out.println("ERROR");
				}
			}else {
				System.out.println("ERROR");
			}
			
		}
		return "VentanaIniciarSesion?faces-redirect=true";
		
	}
	public void loadIniciarSesion() {
		this.lista = iniciarSesionLocal.getIniciarSesion();
	}
	
	public String cambiarContrasenia() {
		loadIniciarSesion();
		for (int i=0; i<this.lista.size();i++) {
			if(iniciarSesion.getUsuario().equals(this.lista.get(i).getUsuario())){
				iniciarSesion.setId(lista.get(i).getId());
				iniciarSesionLocal.cambiarContrasenia(this.iniciarSesion);		
				return "VentanaIniciarSesion?faces-redirect=true";
			}else {
				
				System.out.println("ERROR Usuario Invalido");
			}
		}
		return "VentanaCambiarContrasenia?faces-redirect=true";
	}
	
	public String ventanaCambiar() {
		return "VentanaCambiarContrasenia?faces-redirect=true";
	}
}
