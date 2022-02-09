package ec.edu.ups.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.FacturaONLocal;
import ec.edu.ups.business.GrupoONLocal;
import ec.edu.ups.business.MateriaONLocal;
import ec.edu.ups.business.MatriculaONLocal;
import ec.edu.ups.business.OfertaAcademicaONLocal;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Factura;
import ec.edu.ups.model.Materia;
import ec.edu.ups.model.Matricula;
import ec.edu.ups.model.OfertaAcademica;

@Named
@ViewScoped
public class MatriculaBean implements Serializable{
	
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
	private List<Grupo> grupos =new ArrayList<Grupo>();
	private String carreraElegida;
	private String fecha;
	private String nivelElegido;
	private String[] materiasElegidas;
	private List<String> materiasElegidas2=new ArrayList<String>();
	
	//----------Matricula Variables------------
	static int matriculaNivel;
	static int matriculaEstudainte;
	static int matriculaCarrera;
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
		this.materias=materias2;
		for (int i = 0; i < this.materias.size(); i++) {
			this.grupos.addAll( grupoON.getGrupo2(this.materias.get(i).getId())) ;
		}
		materias2=new ArrayList<Materia>();
	}
	
	public void gruposTable() {

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
				/*int id =this.materias.get(i).getId();
				System.out.println(id);
				materiasElegidas2.add(String.valueOf(id));*/
				materias2.add(this.materias.get(i));
				System.out.println("Se va"+materias2);
			}
		}
		System.out.println("Se fue"+materiasElegidas2);

		return "matriculaGrupos?faces-redirect=true";
		
	}
	
	public String Factura() {
		
		System.out.println(this.factura.getCedula()+this.factura.getNombre()+ this.factura.getCorreo()+this.factura.getDireccion()+this.factura.getTelefono() );
		System.out.println(this.fecha);
		
		matricula.setNivel(matriculaNivel);
		//estudiante.setId(matriculaEstudainte);
		estudiante.setId(1);
		matricula.setEstudiante(estudiante);
		ofertaAcademica.setId(matriculaCarrera);
		matricula.setOfertaAcademica(ofertaAcademica);
		
		//---
		Date date1=null;
		
		try {
			date1 = new SimpleDateFormat("MMddyyyy").parse(this.fecha);
			System.out.println(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//---
		this.factura.setFecha(date1);
		this.factura.setDescuento(0.0);
		this.factura.setIva(0.0);
		this.factura.setDetalle("Matricula Ordinaria "+matriculaNivel);
		this.factura.setSubtotal(2130.00);
		this.factura.setMetodoPago("Efectivo");
		this.factura.setTotal(2130.00);
		matricula.setFactura(this.factura);
		
		System.out.println(matricula);
		try {
			matriculaON.insertar(matricula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "hola";
		
	}
	
	public String grupo() {
		System.out.println("Grupos66: "+ this.grupos);
		return "factura?faces-redirect=true";
	}
	
	
}
