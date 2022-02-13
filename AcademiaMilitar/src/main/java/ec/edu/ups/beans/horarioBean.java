package ec.edu.ups.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.GrupoONLocal;
import ec.edu.ups.model.Grupo;


@Named
@RequestScoped
public class horarioBean {

	@Inject
	private GrupoONLocal gruON;
	
	
	private String cedula;
	private int nivel;
	private List<Grupo>listgrupo = new ArrayList<Grupo>();
	
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	
	public void buscarHorario() {
		nivel=this.getNivel();
		listgrupo= gruON.getGrupo(nivel);
		System.out.println(listgrupo);
	}
}
