package ec.edu.ups.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.GrupoONLocal;
import ec.edu.ups.business.MatriculaON;
import ec.edu.ups.business.MatriculaONLocal;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Matricula;
import ec.edu.ups.model.MatriculaMaterias;


@Named
@RequestScoped
public class horarioBean {

	@Inject
	private GrupoONLocal gruON;
	
	@Inject
	private MatriculaONLocal matriON;

	
	private String cedula;
	private static String cedula2;
	private int nivel;
	private List<Grupo>listgrupo = new ArrayList<Grupo>();
	private List<Matricula> listMatricula = new ArrayList<Matricula>();
	private List<Integer> listGrupos = new ArrayList<Integer>();
	private List<Grupo>gruposMatriuculados=new ArrayList<Grupo>();

	
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
	
	
	
	//listas
	public List<Grupo> getListgrupo() {
		return listgrupo;
	}
	public void setListgrupo(List<Grupo> listgrupo) {
		this.listgrupo = listgrupo;
	}

	public List<Integer> getListGrupos() {
		return listGrupos;
	}
	public void setListGrupos(List<Integer> listGrupos) {
		this.listGrupos = listGrupos;
	}
	
	
	
	
	
	
	
	
	
	
	public List<Matricula> getListMatricula() {
		return listMatricula;
	}
	public void setListMatricula(List<Matricula> listMatricula) {
		this.listMatricula = listMatricula;
	}
	public List<Grupo> getGruposMatriuculados() {
		return gruposMatriuculados;
	}
	public void setGruposMatriuculados(List<Grupo> gruposMatriuculados) {
		this.gruposMatriuculados = gruposMatriuculados;
	}
	
	
	//METODOS
	public void guardarCedula() {
		cedula = this.getCedula();
		cedula2=cedula;
		System.out.println("CEDULA HORARIO BEAN "+cedula);
		System.out.println("CEDULA ESTATICA "+cedula2);
	}
	
	public void buscarHorario() {
		nivel=this.getNivel();

		System.out.println(listgrupo);
		System.out.println("****************************");
		listMatricula=matriON.getMatHorario(cedula);
		
		
		System.out.println(listMatricula);
//
		
		int idMatricula=0;
		int nivelMatricula=0;
		
		System.out.println(listMatricula.size());
		 System.out.println("-------------------------------------------------------------------------------------------------");
		// System.out.println(listMatricula.get(0).getMatMaterias().get(0).getIdGrupo());
		 System.out.println("-------------------------------------------------------------------------------------------------");
		 System.out.println("-------------------------------------------------------------------------------------------------");
		// System.out.println(listMatricula.get(0).getMatMaterias().get(1).getIdGrupo());
		 System.out.println("-------------------------------------------------------------------------------------------------");
		///////////////////////////////////////////////////////////////
		 idMatricula = listMatricula.get(listMatricula.size()-1).getId();
		 nivelMatricula=listMatricula.get(listMatricula.size()-1).getNivel();
		 System.out.println("ID MATRICULA "+idMatricula);
		 System.out.println("NIVEL MATRICULA "+nivelMatricula);
		 
		 for (int i = 0; i < listMatricula.size(); i++) {
			

			 	for (int j = 0; j < listMatricula.get(i).getMatMaterias().size(); j++) {
			 		System.out.println("MATERIAS MATRICULADAS ");
					System.out.println(listMatricula.get(i).getMatMaterias().get(j).getIdGrupo());
					 int grupoMatricula=listMatricula.get(i).getMatMaterias().get(j).getIdGrupo();
					 listGrupos.add(grupoMatricula);
			 	}

		}
		
		comaprarGrupos();
		
		
////////////////////////////////////////////////////////////////////

		
		
		
		
		
		
	}
	
	public void comaprarGrupos() {
		System.out.println("------------------------------------------------");
		System.out.println(listGrupos);
		System.out.println("SIZE LISTGRUPO "+listGrupos.size());
		for (int i = 0; i < listGrupos.size(); i++) {
			System.out.println("------------------------------------------------");
			System.out.println("FOR "+i);
			System.out.println(listGrupos.get(i));
			
			gruposMatriuculados.addAll(gruON.getGrupoB(listGrupos.get(i)));
			
		}
		
		System.out.println(gruposMatriuculados);
	}



}
