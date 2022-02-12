package ec.edu.ups.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.MallaCurricularONLocal;
import ec.edu.ups.model.MallaCurricular;

@Named
@RequestScoped
public class AsignaturaBean {

	@Inject
	private MallaCurricularONLocal mallaON;
	
	private int nivel;
	private String asignaturas;
	private int horas;
	
	private MallaCurricular malla = new MallaCurricular();
	
	private List<MallaCurricular> listMalla;
	
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	public MallaCurricular getMalla() {
		return malla;
	}

	public void setMalla(MallaCurricular malla) {
		this.malla = malla;
	} 

	public List<MallaCurricular> getListMalla() {
		return listMalla;
	}
	public void setListMalla(List<MallaCurricular> listMalla) {
		this.listMalla = listMalla;
	}
//////////////////////////////////////////////////////
	public void loadAsignaturaEditar() {
		MallaCurricular m = mallaON.obtenerDatosAsignatura(malla.getId());
		malla=m;
		System.out.println(malla);
		
	}
/////////////////////////////////////////////////////////	
	public String guardarAsignatura() {
		try {
			malla.setId(id);
			//System.out.println("malla id "+malla.getId());
			System.out.println("ESTA ES LA ID"+id);
				mallaON.guardar(this.malla);
				return "listado-asignaturas?faces-redirect=true";				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Guardando Asignatura"+this.malla.getAsignatura());
		return null;
	}
	
///////////////////////////////////////////////////////////////////////	
	public void loadAsignaturas() {
		this.listMalla = mallaON.getMalla();
	}
////////////////////////////////////////////////////////////////
	public void loadData() {
		if(id==0)
			return;
		
		MallaCurricular ma = mallaON.obtenerDatosAsignatura(id);
		malla=ma;
		
		
	}
/////////////////////////////////////////////////////////////////////	
	public String listaAsignatura() {
		
		return "listado-asignaturas?faces-redirect=true";
	}
////////////////////////////////////////////////////////////////////
	public String editar(int id) {
		System.out.println("Editar"+id);

		malla.setId(id);
		
		return "Asignatura?faces-redirect=true&id="+id;

	}
	//////////////////////////////////////////////////////////////////
	public String eliminar(int id) {
		malla.setId(id);
		System.out.println("ELIMINANDOOO");
		System.out.println("iD ELIMINADO "+malla.getId());
		mallaON.eliminarAsignatura(id);
		return "Asignatura?faces-redirect=true&";

	}
	
	
	
	
}
