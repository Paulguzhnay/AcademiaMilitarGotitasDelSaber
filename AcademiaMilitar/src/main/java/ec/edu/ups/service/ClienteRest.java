package ec.edu.ups.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.business.CalificacionONLocal;
import ec.edu.ups.business.EstudianteONLocal;
import ec.edu.ups.business.MateriaONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.Calificacion;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Materia;
import ec.edu.ups.model.Persona;

@Path("academia")
public class ClienteRest {
	
	@Inject
	private CalificacionONLocal calON;
	
	@Inject
	private EstudianteONLocal estON;
	
	@Inject 
	private PersonaONLocal perON;
	
	@Inject
	private MateriaONLocal matON;
	
	
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

	

	private Materia materia = new Materia();
	private Estudiante estudiante = new Estudiante();


	@GET // get para obtener consultas
	@Produces(MediaType.APPLICATION_JSON)
	public List<Calificacion> buscarCedula(@QueryParam("cedula") String cedula, 
								@QueryParam("nivel") int nivel) {
		
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
		return listCalificacionFinal2;
	}




}
