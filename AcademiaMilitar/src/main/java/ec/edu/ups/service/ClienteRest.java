package ec.edu.ups.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.business.CalificacionONLocal;
import ec.edu.ups.business.EstudianteONLocal;
import ec.edu.ups.business.LibroDiarioONLocal;
import ec.edu.ups.business.MateriaONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.Calificacion;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.LibroDiario;
import ec.edu.ups.model.Materia;
import ec.edu.ups.model.Persona;

@Path("academia")
public class ClienteRest {

	@Inject
	LibroDiarioONLocal libroON;
	
	//Listas
	private List<LibroDiario>listLibro = new ArrayList<LibroDiario>();
	private List<LibroDiario>listLibroFinal = new ArrayList<LibroDiario>();	

	
	private String fecha;
	private LibroDiario libro;
	double suma=0;
	double sumaA=0;


	@GET // get para obtener consultas
	@Produces(MediaType.APPLICATION_JSON)
	public List<LibroDiario> buscarLibroDiario(@QueryParam("fecha") String fecha) {
			//Lista con todo el Libro Diario
			listLibro=libroON.getLibro();
			listLibroFinal = new ArrayList<LibroDiario>();
			suma=0;
			sumaA=0;
			//
	
			SimpleDateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
			 Date fechaDate = null;
			try {
				fechaDate = formato.parse(fecha);
		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			for (int i = 0; i < listLibro.size(); i++) {
				
				
				if (fechaDate.equals(listLibro.get(i).getFecha())) {
					libro= new LibroDiario();
					sumaA=listLibro.get(i).getValorTotal();
					suma=suma+sumaA;
					
					libro.setId(listLibro.get(i).getId());
					libro.setFecha(listLibro.get(i).getFecha());
					libro.setValorTotal(sumaA);
					listLibroFinal.add(libro);
				}
			}	
			return listLibroFinal;
		}
}
