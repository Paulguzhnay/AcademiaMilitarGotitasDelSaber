package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.DocenteONLocal;
import ec.edu.ups.model.Docente;
import ec.edu.ups.model.Persona;

@Named
@ViewScoped
public class DocentesBean implements Serializable {
	
	@Inject
	DocenteONLocal docentesOn;
	
	Docente docentes = new Docente();
	Persona persona = new Persona();
	
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	List<Docente> lista = new ArrayList<Docente>();
	
	@PostConstruct
	public void init() {
		this.loadDocentes();
	}
	
	private void loadDocentes() {
		this.lista= docentesOn.getDocente();
		
	}

	public List<Docente> getLista() {
		return lista;
	}
	public void setLista(List<Docente> lista) {
		this.lista = lista;
	}
	public Docente getDocentes() {
		return docentes;
	}
	public void setDocentes(Docente docentes) {
		this.docentes = docentes;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public String informacion(int id) {
		System.out.println("El id es "+id);
		return "InfoDocente?faces-redirect=true&id="+id;
	}
	public void loadDataEditar() {
		Docente p = docentesOn.getDocentes(docentes.getId());
		docentes = p;
	}
	
	public void loadData() {
		if(id==0)
			return;
		
		Docente p = docentesOn.getDocentes(id);
		docentes = p;
	}
	public String regresar() {
		return "VentanaDocentes?faces-redirect=true";
	}
	

}
