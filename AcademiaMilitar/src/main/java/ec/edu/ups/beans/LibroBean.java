package ec.edu.ups.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.LibroDiarioONLocal;
import ec.edu.ups.model.LibroDiario;

@Named
@ViewScoped
public class LibroBean implements Serializable {

	@Inject
	LibroDiarioONLocal libroON;
	
	//Listas
	private List<LibroDiario>listLibro = new ArrayList<LibroDiario>();
	private List<LibroDiario>listLibroFinal = new ArrayList<LibroDiario>();	

	
	private String fecha;
	private LibroDiario libro;
	double suma=0;
	double sumaA=0;
	
	
	
	
	
	
	public double getSuma() {
		return suma;
	}


	public void setSuma(double suma) {
		this.suma = suma;
	}


	public double getSumaA() {
		return sumaA;
	}


	public void setSumaA(double sumaA) {
		this.sumaA = sumaA;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	//GETTERS Y SETTERS
	public List<LibroDiario> getListLibro() {
		return listLibro;
	}


	public void setListLibro(List<LibroDiario> listLibro) {
		this.listLibro = listLibro;
	}
	
	public List<LibroDiario> getListLibroFinal() {
		return listLibroFinal;
	}


	public void setListLibroFinal(List<LibroDiario> listLibroFinal) {
		this.listLibroFinal = listLibroFinal;
	}

//Metodos
	


	public String obtenerRegistros()  {
		
		//Lista con todo el Libro Diario
		listLibro=libroON.getLibro();
		listLibroFinal = new ArrayList<LibroDiario>();
		suma=0;
		sumaA=0;
		//
		fecha= this.getFecha();
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
		return null;
	}
	
	/*public void Libro() {
		Date fecha2;
		
		SimpleDateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
		 Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println();
		System.out.println(formato);
		System.out.println(fechaDate);
		listLibro = libroON.getLibro(fechaDate);
		System.out.println(listLibro);
	}*/
		
	
}
