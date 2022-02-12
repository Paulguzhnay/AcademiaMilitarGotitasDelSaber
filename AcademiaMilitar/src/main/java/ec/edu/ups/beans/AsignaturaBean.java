package ec.edu.ups.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import org.xml.sax.HandlerBase;

import ec.edu.ups.business.DocenteON;
import ec.edu.ups.business.DocenteONLocal;
import ec.edu.ups.business.GrupoONLocal;
import ec.edu.ups.business.HorarioONLocal;
import ec.edu.ups.business.MallaCurricularONLocal;
import ec.edu.ups.business.MateriaONLocal;
import ec.edu.ups.business.espacioFisicoONLocal;
import ec.edu.ups.dao.EspacioFisicoDAO;
import ec.edu.ups.model.Docente;
import ec.edu.ups.model.EspacioFisico;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Horario;
import ec.edu.ups.model.MallaCurricular;
import ec.edu.ups.model.Materia;

@Named
@RequestScoped
public class AsignaturaBean {

	@Inject
	private MallaCurricularONLocal mallaON;
	
	@Inject
	private MateriaONLocal matON;
	
	@Inject
	private DocenteONLocal docON;
	
	@Inject
	private espacioFisicoONLocal espON;
	
	@Inject
	private GrupoONLocal gruON;
	
	@Inject
	private HorarioONLocal horON;
	
	
	private int nivel;
	private String asignaturas;
	
	private MallaCurricular malla = new MallaCurricular();
	private Materia materia = new Materia();
	private Grupo grupo = new Grupo();
	private Docente docente = new Docente();
	private EspacioFisico espF = new EspacioFisico();
	private Horario horario = new Horario();
	
	
	
	private List<Materia>listMateria;
	private List<MallaCurricular> listMalla;
	private List<MallaCurricular>ListMallaMateria;
	private List<Docente>listDocente;
	
	private int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@PostConstruct
	public void init() {
		this.loadAsignaturas();
	}
	
	
	
	public AsignaturaBean() {
		
	}
	
	
	public EspacioFisico getEspF() {
		return espF;
	}
	public void setEspF(EspacioFisico espF) {
		this.espF = espF;
	}
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	public MallaCurricular getMalla() {
		return malla;
	}

	public void setMalla(MallaCurricular malla) {
		this.malla = malla;
	} 

	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
	
	
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	//Listas
	public List<MallaCurricular> getListMalla() {
		return listMalla;
	}
	public List<MallaCurricular> getListMallaMateria() {
		return ListMallaMateria;
	}

	
	public void setListMallaMateria(List<MallaCurricular> listMallaMateria) {
		ListMallaMateria = listMallaMateria;
	}
	public void setListMalla(List<MallaCurricular> listMalla) {
		this.listMalla = listMalla;
	}
	
	
	public List<Materia> getListMateria() {
		return listMateria;
	}
	public void setListMateria(List<Materia> listMateria) {
		this.listMateria = listMateria;
	}
	
	public List<Docente> getListDocente() {
		return listDocente;
	}
	public void setListDocente(List<Docente> listDocente) {
		this.listDocente = listDocente;
	}
	//////////////////////////////////////////////////////
	public void loadAsignaturaEditar() {
		Materia mat = matON.obtenerDatosAsignatura(materia.getId());
		materia = mat;
		
		
		/*MallaCurricular m = mallaON.obtenerDatosAsignatura(malla.getId());
		malla=m;
		System.out.println(malla);*/
		
	}
/////////////////////////////////////////////////////////	
	public String guardarAsignatura() {
		try {
//			malla.setId(id);
			materia.setId(id);
			//System.out.println("malla id "+malla.getId());
			System.out.println("ESTA ES LA ID"+id);
			matON.guardar(this.materia);
			//mallaON.guardar(this.malla);
				return "listado-asignaturas?faces-redirect=true";				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Guardando Asignatura"+this.malla.getAsignatura());
		return null;
	}
	
///////////////////////////////////////////////////////////////////////	
	
	
	public String guardarMateria() {
		try {
//			malla.setId(id);
			//materia.setId(id);
			
			//***************************MATERIA***************************************************
			System.out.println("Nombre de Materia "+materia.getNombre());
			System.out.println("Nivel de Materia "+materia.getNivel());

			
			//Insert de la Materia
			matON.insertar(materia);
			//
			//******************************ESPACIO FISICO******************************************************
			System.out.println("Nombre del Edificio "+espF.getNombreEdificio());
			System.out.println("Numero de Aula "+espF.getNumeroAula());
			//Insert del Espacio Fisico
			espON.insertar(espF);
			
			//----------------------------HORARIO-----------------------------------------------
			
			System.out.println("Dia Horario "+horario.getDia());
			System.out.println("Hora Horario "+horario.getHora());			
			System.out.println("ID ESPACIO"+espF.getId());
			horario.setEspacio(espF);
			horON.insertar(horario);

			//----------------------------------------------------------------------------------------
			
			System.out.println("ID DOCENTE "+docente.getId());
			System.out.println("ID MATERIA "+materia.getId());
			System.out.println("Numero del grupo "+grupo.getNumeroGrupo());
			System.out.println("Nivel del grupo "+grupo.getNivel());
			System.out.println(materia);
			
	
			
			System.out.println("*************************************************************");
			System.out.println("ID MATERIA 2   "+materia.getId());

			grupo.setDocente(docente);
			grupo.setMateria(materia);
			grupo.setHorario(horario);
			gruON.insertar(grupo);
			
			///////////////////SETEO/////////////////////////

			
			
			//matON.guardar(this.materia);
			//mallaON.guardar(this.malla);
				return null;				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Guardando Asignatura"+this.malla.getAsignatura());
		return null;
	}
	//////////////////////////////////////////////////////////////////////
	public void loadAsignaturas() {
		this.listMalla = mallaON.getMalla();
		this.listDocente = docON.getDocente();
		System.out.println(listMalla.size()+" SIZE");
//		
	}
////////////////////////////////////////////////////////////////
	public void loadData() {
		if(id==0)
			return;
		
		Materia ma = matON.obtenerDatosAsignatura(id);
		materia = ma;
//		MallaCurricular ma = mallaON.obtenerDatosAsignatura(id);
	//	malla=ma;
		
		
	}
/////////////////////////////////////////////////////////////////////	
	public String listaAsignatura() {
		
		return "listado-asignaturas?faces-redirect=true";
	}
////////////////////////////////////////////////////////////////////
	public String editar(int id) {
		System.out.println("Editar"+id);

		materia.setId(id);
//		malla.setId(id);
		
		return "Asignatura?faces-redirect=true&id="+id;

	}
	//////////////////////////////////////////////////////////////////
	public String eliminar(int id) {
		//malla.setId(id);
		materia.setId(id);
		System.out.println("ELIMINANDOOO");
		System.out.println("iD ELIMINADO "+materia.getId());
		matON.eliminarAsignatura(id);
		return "Asignatura?faces-redirect=true&";

	}
	
	
	
	
	
}
