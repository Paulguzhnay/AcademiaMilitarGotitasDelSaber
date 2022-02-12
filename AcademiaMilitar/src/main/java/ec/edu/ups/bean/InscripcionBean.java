package ec.edu.ups.bean;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.InscripcionONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.IniciarSesion;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Persona;


@Named
@RequestScoped
public class InscripcionBean {
	
	@Inject
	private InscripcionONLocal inscripcionLocal;
	
	@Inject
	private PersonaONLocal personaLocal;
	
	private Inscripcion inscripcion = new Inscripcion();

	private Persona persona = new Persona();
	
	private IniciarSesion iniciarSesion = new IniciarSesion();
	
	private List<Inscripcion> lista;
	
	@PostConstruct
	public void init() {
		//this.loadInscripciones();
	}

	public List<Inscripcion> getLista() {
		return lista;
	}

	public void setLista(List<Inscripcion> lista) {
		this.lista = lista;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String guardar() {
		
		/*Inscripcion i = new Inscripcion();
		i.setCarrera(this.inscripcion.getCarrera());
		i.setFechaRegistro(this.inscripcion.getFechaRegistro());
		i.setJornada(this.inscripcion.getJornada());
		i.setModalidad(this.inscripcion.getModalidad());
		i.setPeriodoLectivo(this.inscripcion.getPeriodoLectivo());
		
		Persona p = new Persona();
		
		p.setCedula(this.inscripcion.getPersona().getCedula());
		p.setNombres(this.inscripcion.getPersona().getNombres());
		p.setApellidos(this.inscripcion.getPersona().getApellidos());
		p.setDireccion(this.inscripcion.getPersona().getDireccion());
		p.setCelular(this.inscripcion.getPersona().getCelular());
		p.setFechaNacimiento(this.inscripcion.getPersona().getFechaNacimiento());
		p.setGenero(this.inscripcion.getPersona().getGenero());
		
		i.setPersona(p);*/
		
		System.out.println("Guardando Inscripcion");
		try {
			inscripcion.setIniciarSesion(credenciales());
			inscripcionLocal.insertar(this.inscripcion);
			
			//clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "VentanaIniciarSesion?faces-redirect=true";
	}
	
	public void loadInscripciones() {
		this.lista = inscripcionLocal.getInscripcions();
	}
	
	public String crearPassword() {
		
		int length = 12;
		
		String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	    String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	    String NUMBER = "0123456789";

	    String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	    SecureRandom random = new SecureRandom();

	    if (length < 1) throw new IllegalArgumentException();

	    StringBuilder sb = new StringBuilder(length);
	    
	    for (int i = 0; i < length; i++) {
	        // 0-62 (exclusive), retornos aleatorios 0-61
	        int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
	        char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

	        sb.append(rndChar);
	    }

	    return sb.toString();
	}

	public IniciarSesion credenciales() {
		
		String usuario = inscripcion.getPersona().getNombres().substring(0,1).toLowerCase()+inscripcion.getPersona().getApellidos().split(" ")[0].trim().toLowerCase()+"@amilitar.edu.ec";
		String pasword = crearPassword();
		IniciarSesion is = new IniciarSesion();
		is.setUsuario(usuario);
		is.setContrasenia(pasword);
		is.setInscripcion(inscripcion);
		return is;
	}
	
	public void transfromarFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
            persona.setFechaNacimiento(fechaDate);
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
		
	}

}
