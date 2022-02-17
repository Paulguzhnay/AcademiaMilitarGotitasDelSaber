package ec.edu.ups.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotEmpty;

import ec.edu.ups.business.FacturaONLocal;
import ec.edu.ups.business.GrupoONLocal;
import ec.edu.ups.business.MateriaONLocal;
import ec.edu.ups.business.MatriculaONLocal;
import ec.edu.ups.business.OfertaAcademicaONLocal;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.LibroDiario;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Factura;
import ec.edu.ups.model.Materia;
import ec.edu.ups.model.Matricula;
import ec.edu.ups.model.MatriculaMaterias;
import ec.edu.ups.model.OfertaAcademica;
import ec.edu.ups.model.Persona;


@Named
@ViewScoped
@FacesValidator("cedulaValidador")
public class MatriculaBean implements Serializable, Validator{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private OfertaAcademicaONLocal ofertaAcademicaON;
	
	@Inject
	private MateriaONLocal materiaON;
	
	@Inject
	private GrupoONLocal grupoON;
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private MatriculaONLocal matriculaON;
	
	
	
	
	private Matricula matricula =new Matricula();
	private Factura factura=new Factura();
	private Materia mate=new Materia();
	private Estudiante estudiante=new Estudiante();
	private OfertaAcademica ofertaAcademica=new OfertaAcademica();
	private Persona persona=new Persona();
	private LibroDiario libro=new LibroDiario();
	
	public LibroDiario getLibro() {
		return libro;
	}

	public void setLibro(LibroDiario libro) {
		this.libro = libro;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Materia getMate() {
		return mate;
	}

	public void setMate(Materia mate) {
		this.mate = mate;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	private List<OfertaAcademica> ofertas;
	private List<Materia> materias;
	static List<Materia> materias2=new ArrayList<Materia>();
	static List<MatriculaMaterias>gruposMatriculados=new ArrayList<MatriculaMaterias>();
	private List<Grupo> grupos =new ArrayList<Grupo>();
	private String carreraElegida;
	private String fecha;
	private String nivelElegido;
	private String[] materiasElegidas;
	private List<String> materiasElegidas2=new ArrayList<String>();
	private String cedula1;
	
	public String getCedula1() {
		return cedula1;
	}

	public void setCedula1(String cedula1) {
		this.cedula1 = cedula1;
	}

	//----------Matricula Variables------------
	static int matriculaNivel;
	static int matriculaEstudainte;
	static int matriculaCarrera;
	static String cedula;
	//----------------------
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	
	public String[] getMateriasElegidas() {
		return materiasElegidas;
	}

	public void setMateriasElegidas(String[] materiasElegidas) {
		this.materiasElegidas = materiasElegidas;
	}

	
	
	public List<String> getMateriasElegidas2() {
		return materiasElegidas2;
	}

	public void setMateriasElegidas2(List<String> materiasElegidas2) {
		this.materiasElegidas2 = materiasElegidas2;
	}

	

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	
	
	
	
	public String getNivelElegido() {
		return nivelElegido;
	}

	public void setNivelElegido(String nivelElegido) {
		this.nivelElegido = nivelElegido;
	}

	private boolean materiaEstado;
	
	
	public boolean isMateriaEstado() {
		return materiaEstado;
	}

	public void setMateriaEstado(boolean materiaEstado) {
		this.materiaEstado = materiaEstado;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	

	public List<OfertaAcademica> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<OfertaAcademica> ofertas) {
		this.ofertas = ofertas;
	}

	public String getCarreraElegida() {
		return carreraElegida;
	}

	public void setCarreraElegida(String carreraElegida) {
		this.carreraElegida = carreraElegida;
	}

	
	

	
	
	
	//----------------------------------------//
	@PostConstruct
	public void init() {
		this.loadCarreras();
		//this.loadMaterias();
	}
	
	
	public void loadCarreras() {
		this.ofertas=ofertaAcademicaON.getOfertaAcademicas();
		System.out.println(this.ofertas);
		
	}
	
	public void loadMaterias() {
		System.out.println("ventana materias-nivel ="+nivelElegido);
		System.out.println("ventana materias-carrera ="+carreraElegida);
		this.materias=materiaON.getMateriasCarrera(Integer.parseInt(nivelElegido), Integer.parseInt(carreraElegida) );
		
		System.out.println(this.materias);
		
	}
	
	public void loadGrupos() {
		//this.grupos=grupoON.getGrupo();
		//System.out.println("llego "+materiasElegidas2);
		System.out.println("llego a grupos"+materias2);
		List<Grupo> gru=new ArrayList<Grupo>();
		this.materias=materias2;
		for (int i = 0; i < this.materias.size(); i++) {
			this.grupos.addAll( grupoON.getGrupo2(this.materias.get(i).getId())) ;
			gru.addAll(this.grupos);
			this.materias.get(i).setGrupos(this.grupos);
			this.grupos =new ArrayList<Grupo>();
		}
		materias2=new ArrayList<Materia>();
		this.grupos=gru;
		System.out.println("Grupos finales"+ this.grupos);
	}
	
	public void gruposTable() {

	}
	
	public void guardarCedula() {
		System.out.println(this.cedula1);
		cedula=this.cedula1;
	}
	
	public String Datos() {
		
		System.out.println("Carrera: "+ carreraElegida);
		System.out.println("Nivel "+ nivelElegido);
		matriculaNivel=Integer.parseInt(nivelElegido);
		matriculaCarrera=Integer.parseInt(carreraElegida);

		return "matriculaMaterias?faces-redirect=true&nivel="+nivelElegido+"&carrera="+carreraElegida;
		
	}
	
	public String Materias() {
		
		System.out.println("Materias66: "+ this.materias);
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).isSeleccionado()==true) {
				materias2.add(this.materias.get(i));
				System.out.println("Se va"+materias2);
			}
		}
		

		return "matriculaGrupos?faces-redirect=true";
		
	}
	
	public String Factura() {
		System.out.println(cedula);
		matricula.setNivel(matriculaNivel);
		
		estudiante.setCicloCursando(matriculaNivel);
		persona.setCedula(cedula);
		estudiante.setPersona(persona);
		matricula.setEstudiante(estudiante);
		ofertaAcademica.setId(matriculaCarrera);
		matricula.setOfertaAcademica(ofertaAcademica);
		//---
		
		
		Date fecha=new Date();
		
		this.factura.setFecha(fecha);
		this.factura.setDescuento(0.0);
		this.factura.setIva(0.0);
		this.factura.setDetalle("Matricula Ordinaria "+matriculaNivel);
		this.factura.setSubtotal(2130.00);
		this.factura.setMetodoPago("Efectivo");
		this.factura.setTotal(2130.00);
		this.factura.setEstado(false);
		libro.setFecha(fecha);
		libro.setValorTotal(2130.00);
		this.factura.setLibroDiario(libro);
		matricula.setFactura(this.factura);
		System.out.println("llego grupos0"+ gruposMatriculados);
		matricula.setMatMaterias(gruposMatriculados);
		System.out.println("se va en set "+ matricula.getMatMaterias());
		System.out.println(matricula);
		try {
			matriculaON.insertar(matricula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gruposMatriculados=new ArrayList<MatriculaMaterias>();
		materias2=new ArrayList<Materia>();
		
		return "interfazUsuario?faces-redirect=true&id="+cedula;
		
	}
	
	public String grupo() {
		
		System.out.println("Grupos66: "+this.grupos);
		
		for (int i = 0; i < this.grupos.size(); i++) {
			if (this.grupos.get(i).isSeleccionado()==true) {
				MatriculaMaterias gruposMatricula=new MatriculaMaterias();
				gruposMatricula.setIdGrupo(this.grupos.get(i).getId());
				gruposMatriculados.add(gruposMatricula);
				//System.out.println("Se va"+gruposMatriculados);
			}
		}
		//System.out.println(cedula);
		return "factura?faces-redirect=true";
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	 	String cedula1 = (String) value;
		
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
