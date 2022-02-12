package ec.edu.ups.bean;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ec.edu.ups.business.InscripcionONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.IniciarSesion;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Persona;


@Named
@RequestScoped
@FacesValidator("validarCedula")
public class inscripcionBean implements Validator {
	
	@Inject
	private InscripcionONLocal inscripcionLocal;
	
	@Inject
	private PersonaONLocal personaLocal;
	
	private Inscripcion inscripcion = new Inscripcion();

	private Persona persona = new Persona();
	
	private IniciarSesion iniciarSesion = new IniciarSesion();
	
	private List<Inscripcion> lista;
	
	private String cedula;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@PostConstruct
	public void init() {
		
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
		
		System.out.println("Guardando Inscripcion");
		try {
			inscripcion.setIniciarSesion(credenciales());
			inscripcionLocal.insertar(this.inscripcion);
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
		Properties propiedad = new Properties();
		propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "infoamilitar@gmail.com";
        String contrasena = "adminMilitar";
        String receptor = inscripcion.getPersona().getCorreoPersonal();
        String asunto = "Credenciales para Portal Educativo Academia Militar";
        String mensaje="Estimado Estudiante en el siguiente correo le enviamos sus credenciales para el portal educativo: Correo Institucional: "+is.getUsuario()+" Contraseña: "+is.getContrasenia();
        
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();            
            
        } catch (AddressException ex) {
            System.out.println("ERROR");
        } catch (MessagingException ex) {
            System.out.println("ERROR");
        }
        
		return is;
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String cedula1 = (String) value;
		System.out.println("HOLAAAA"+cedula1);
		boolean cedulaCorrecta = false;	 
		try {
			if (cedula1.length() == 10){
				int tercerDigito = Integer.parseInt(cedula1.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula1.substring(9,10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula1.length() - 1); i++) {
						digito = Integer.parseInt(cedula1.substring(i, i + 1))* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
			 
					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					}else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				}else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
			throw new ValidatorException(new FacesMessage("Error de Validación"));
		}	 
			
		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
			throw new ValidatorException(new FacesMessage("Cédula Incorrecta"));
		}
	}

}
