package ec.edu.ups.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.CalificacionONLocal;
import ec.edu.ups.business.EstudianteONLocal;
import ec.edu.ups.business.MateriaONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.Calificacion;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Materia;
import ec.edu.ups.model.Persona;

@Named
@RequestScoped
public class EstudianteBean {

	
	@Inject
	private CalificacionONLocal calON;
	
	@Inject
	private EstudianteONLocal estON;
	
	@Inject 
	private PersonaONLocal perON;
	
	@Inject
	private MateriaONLocal matON;
	
	//listas
	private List<Calificacion>listCalificaciones;
	private List<Estudiante>listEstudiante;
	private List<Materia>listMateria;
	private List<Grupo>listGrupo;
	private List<Persona>listPersona;
	private List<Calificacion>listCalificacionEst=new ArrayList<Calificacion>();
	private List<Materia>listMateriaEst= new ArrayList<Materia>();
	private Calificacion cal;
	private List<Calificacion>listCalificacionFinal=new ArrayList<Calificacion>();
	private List<Calificacion>listCalificacionFinal2=new ArrayList<Calificacion>();
	//cedula
	private String cedula;
	private int nivel;
	static String cedula2;

	private Materia materia = new Materia();
	private Estudiante estudiante = new Estudiante();
	
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

//GETTERS Y SETTERS DE LISTAS
	public List<Calificacion> getListCalificaciones() {
		return listCalificaciones;
	}

	public void setListCalificaciones(List<Calificacion> listCalificaciones) {
		this.listCalificaciones = listCalificaciones;
	}

	public List<Estudiante> getListEstudiante() {
		return listEstudiante;
	}

	public void setListEstudiante(List<Estudiante> listEstudiante) {
		this.listEstudiante = listEstudiante;
	}

	public List<Materia> getListMateria() {
		return listMateria;
	}

	public void setListMateria(List<Materia> listMateria) {
		this.listMateria = listMateria;
	}

	public List<Grupo> getListGrupo() {
		return listGrupo;
	}

	public void setListGrupo(List<Grupo> listGrupo) {
		this.listGrupo = listGrupo;
	}

	public List<Persona> getListPersona() {
		return listPersona;
	}

	public void setListPersona(List<Persona> listPersona) {
		this.listPersona = listPersona;
	}

	public List<Calificacion> getListCalificacionEst() {
		return listCalificacionEst;
	}

	public void setListCalificacionEst(List<Calificacion> listCalificacionEst) {
		this.listCalificacionEst = listCalificacionEst;
	}

	public List<Materia> getListMateriaEst() {
		return listMateriaEst;
	}

	public void setListMateriaEst(List<Materia> listMateriaEst) {
		this.listMateriaEst = listMateriaEst;
	}
	public List<Calificacion> getListCalificacionFinal() {
		return listCalificacionFinal;
	}

	public void setListCalificacionFinal(List<Calificacion> listCalificacionFinal) {
		this.listCalificacionFinal = listCalificacionFinal;
	}

	
	public List<Calificacion> getListCalificacionFinal2() {
		return listCalificacionFinal2;
	}

	public void setListCalificacionFinal2(List<Calificacion> listCalificacionFinal2) {
		this.listCalificacionFinal2 = listCalificacionFinal2;
	}

	//METODOS
	public String buscarCedula() {
		cedula2=this.getCedula();
		cedula = this.getCedula();
		nivel = this.getNivel();
		int contador=0;
		int estID = 0;
		int idMateria=0;
		int nivelMateria = 0;
		if (cedula.length()==10 && nivel>0) {

			listEstudiante=estON.getEstudiante();
			listCalificaciones=calON.getCalificacion();
			
			//RECUPERACION DEL ID DEL ESTUDIANTE
			for(int i=0; i<listEstudiante.size();i++) {
				String ceduE=listEstudiante.get(i).getPersona().getCedula();				
				
				if (ceduE.equals(cedula)) {
				 estID=listEstudiante.get(i).getId();
				 System.out.println("estudiante ID "+estID);
				 break;
				}
			}
			//LISTA DE TODAS LAS MATERIAS
			listMateria =matON.getMaterias();
			//LISTA CON LAS CALIFICACIONES DEL ESTUDIANTE EN BUSQUEDA
			for(int i=0;i<listCalificaciones.size();i++) {
				
				if (listCalificaciones.get(i).getEstudiante().getId()==estID) {
					
					
					cal = new Calificacion();
					materia = new Materia();
					estudiante = new Estudiante();	
					
					

							int idCalMateria =listCalificaciones.get(i).getMateria().getId();
							
							if (i<listMateria.size()) {
								idMateria = listMateria.get(i).getId();
								nivelMateria=listMateria.get(i).getNivel();		
								
							}

										
								if((idCalMateria==idMateria)&&(nivel==nivelMateria)) {
									materia.setId(listMateria.get(i).getId());
									materia.setNivel(listMateria.get(i).getNivel());
									materia.setNombre(listMateria.get(i).getNombre());
									listMateriaEst.add(materia);
								}								
							
							contador=contador+1;
					//SETEO EN LA LISTA
					cal.setId(listCalificaciones.get(i).getId());
					cal.setNotaObtenida(listCalificaciones.get(i).getNotaObtenida());
					estudiante.setId(listCalificaciones.get(i).getEstudiante().getId());
					cal.setEstudiante(estudiante);
					materia.setId(listCalificaciones.get(i).getMateria().getId());
					cal.setMateria(materia);
					listCalificacionEst.add(cal);
					
				}
			}
			
	
			//Obtener todas las materias 

			System.out.println("SIZE DE LA MATERIA "+listMateriaEst.size());
			System.out.println("SIZE DE LA NOTAS "+listCalificacionEst.size());

			//
			
			int sizeMateria=listMateriaEst.size();
			int cont2=0;
			int cont3=0;
			//
			for (int i = 0; i < listCalificacionEst.size(); i++) {
				if (cont2>sizeMateria) {
					cont2=0;
					
				}
				if(i<listMateriaEst.size()) {
					if(listMateriaEst.get(i).getId()==listCalificacionEst.get(i).getMateria().getId()) {
						
					}
				}
				
				if (cont3<2) {
					int j=0;
					if (cont2<sizeMateria) {
						

						for (j=0; j <listCalificacionEst.size(); j++) {
							cal = new Calificacion();
							estudiante = new Estudiante();
							materia = new Materia();
							if (listMateriaEst.get(cont2).getId()==listCalificacionEst.get(j).getMateria().getId()) {
								//SETTEO
								double nota = listCalificacionEst.get(j).getNotaObtenida();
								cal.setId(listCalificacionEst.get(j).getMateria().getId());
								cal.setNotaObtenida(nota);
								estudiante.setId(listCalificacionEst.get(j).getEstudiante().getId());
								cal.setEstudiante(estudiante);
								materia.setId(listCalificacionEst.get(j).getMateria().getId());
								cal.setMateria(materia);
								listCalificacionFinal.add(cal);
							
							}
													
						}
						cont2=cont2+1;
					}
					
				}
				cont3=cont3+1;
			}
			
			System.out.println("SIZE FINAL"+listCalificacionFinal.size());
			
			//SUMA DE NOTAS 
			int con=0;
			int con2=0;
			int maximo=listMateriaEst.size();
			double suma=0;
			double sumaAux;
			for (int j = 0; j < listCalificacionFinal.size(); j++) {
				cal = new Calificacion();
				estudiante = new Estudiante();
				materia = new Materia();
				if (con>listMateriaEst.size()) {
					con=0;
				}
				
				
				if (listCalificacionFinal.get(j).getMateria().getId()==listMateriaEst.get(con).getId()) {
					sumaAux=listCalificacionFinal.get(j).getNotaObtenida();
					suma=suma+sumaAux;
					//setteo
					cal.setId(listCalificacionFinal.get(j).getId());
					cal.setNotaObtenida(suma);
					estudiante.setId(listCalificacionFinal.get(j).getEstudiante().getId());
					cal.setEstudiante(estudiante);
					materia.setId(listCalificacionFinal.get(j).getId());
					cal.setMateria(materia);
					listCalificacionFinal2.add(cal);
					System.out.println("SUMA "+suma);
					
					
				}
				
			}
			System.out.println("SIZE FINAL  "+listCalificacionFinal2.size());
			con=con+1;
			
			
		}
		return "CalificacionEstudiante?faces-redirect=true&id="+cedula;
	}
	
	
	////////////////////////////////////////////////////////////
	public void validate(FacesContext context, UIComponent arg1, 
			Object arg2) {
		String x=((String)arg2);
	    int suma=0;
	    int contador=0;
	    for(int i = 0; i < x.length() ; i++){   // while counting characters if less than the length add one        
	        char character = x.charAt(i); // start on the first character
	        int ascii = (int) character; //convert the first character
	        if(ascii>47 && ascii<58) {
	        	contador=contador+1;
	        	System.out.println("cONTADOR "+contador);
	        }else {
	            throw new ValidatorException(new FacesMessage("Caracteres Invalidos"));
			}
	        
	    }
	    
	    
		    if(x.length()<10){
			      System.out.println("Ingrese su cedula de 10 digitos");
		          throw new ValidatorException(new FacesMessage("Faltan caracteres"));
			    }else{
			      int a[]=new int [x.length()/2];
			      int b[]=new int [(x.length()/2)];
			      int c=0;
			      int d=1;
			      for (int i = 0; i < x.length()/2; i++) {
			        a[i]=Integer.parseInt(String.valueOf(x.charAt(c)));
			        c=c+2;
			        if (i < (x.length()/2)-1) {
			          b[i]=Integer.parseInt(String.valueOf(x.charAt(d)));
			          d=d+2;
			        }
			      }
			   
			      for (int i = 0; i < a.length; i++) {
			        a[i]=a[i]*2;
			        if (a[i] >9){
			          a[i]=a[i]-9;
			        }
			        suma=suma+a[i]+b[i];
			      } 
			      int aux=suma/10;
			      int dec=(aux+1)*10;
			      if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length()-1)))) {
			          throw new ValidatorException(new FacesMessage("Cedula Correcta"));
			      }else
			        if(suma%10==0 && x.charAt(x.length()-1)=='0'){
				          throw new ValidatorException(new FacesMessage("Cedula Correcta"));
			        }else{
				          throw new ValidatorException(new FacesMessage("Cedula Incorrecta"));
			        }	
				
				}
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////

public void validarN(FacesContext context, UIComponent arg1, 
		Object arg2) {
    int contador=0;
	String x=((String)arg2);
    for(int i = 0; i < x.length() ; i++){   // while counting characters if less than the length add one        
        char character = x.charAt(i); // start on the first character
        int ascii = (int) character; //convert the first character
        if(ascii>47 && ascii<58) {
        	contador=contador+1;
        	System.out.println("cONTADOR "+contador);
            throw new ValidatorException(new FacesMessage("Nivel Valido"));
        }else {
            throw new ValidatorException(new FacesMessage("Nivel Invalido"));
		}
        
    }
}
	

}