package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.EstudianteONLocal;
import ec.edu.ups.business.FacturaONLocal;
import ec.edu.ups.business.MatriculaONLocal;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Factura;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Matricula;

@Named
@ViewScoped
public class EstudianteCuentasBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private MatriculaONLocal matriculaON;
	
	@Inject
	private EstudianteONLocal estudianteON;
	
	private List<Matricula> facturas=new ArrayList<Matricula>();
	private List<Estudiante> estudiantes =new ArrayList<Estudiante>();
	private Factura facDetalle=new Factura();
	static Factura factDetalle2;
	private List<Factura>detalles=new ArrayList<Factura>();
	private String fecha;
	private boolean facturasPagadas;
	private boolean facturasPendientes;
	


	public boolean isFacturasPagadas() {
		return facturasPagadas;
	}

	public void setFacturasPagadas(boolean facturasPagadas) {
		this.facturasPagadas = facturasPagadas;
	}

	public boolean isFacturasPendientes() {
		return facturasPendientes;
	}

	public void setFacturasPendientes(boolean facturasPendientes) {
		this.facturasPendientes = facturasPendientes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public static Factura getFactDetalle2() {
		return factDetalle2;
	}

	public static void setFactDetalle2(Factura factDetalle2) {
		EstudianteCuentasBean.factDetalle2 = factDetalle2;
	}

	private String idEstudiante;
	private String cedula;
	static String cedula1;

	public List<Factura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Factura> detalles) {
		this.detalles = detalles;
	}

	public Factura getFacDetalle() {
		return facDetalle;
	}

	public void setFacDetalle(Factura facDetalle) {
		this.facDetalle = facDetalle;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public List<Matricula> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Matricula> facturas) {
		this.facturas = facturas;
	}
	
	/*@PostConstruct
	public void init() {
		this.loadFacturas();
	}*/
	
	public void loadFacturas() {
		
		this.estudiantes=estudianteON.getEstudianteCuenta(this.cedula);
		cedula1=this.cedula;
		for (int i = 0; i < this.estudiantes.size(); i++) {
			this.facturas.addAll( matriculaON.getMatFact(this.estudiantes.get(i).getId()));

		}
	}
	public void loadFacturasPagadas() {
		loadFacturas();
		
		List<Matricula> facturasPagadas=new ArrayList<Matricula>();
		for (int i = 0; i < this.facturas.size(); i++) {
			if (this.facturas.get(i).getFactura().isEstado()==true) {
				facturasPagadas.add(this.facturas.get(i)) ;
			} 
		}
		
		this.facturas=new ArrayList<Matricula>();
		
		this.facturas=facturasPagadas;
		this.facturasPagadas=true;
		this.facturasPendientes=false;
		
}
	
	public void loadFacturasPendientes() {
		loadFacturas();
		
		List<Matricula> facturasPendientes=new ArrayList<Matricula>();
		for (int i = 0; i < this.facturas.size(); i++) {
			if (this.facturas.get(i).getFactura().isEstado()==false) {
				facturasPendientes.add(this.facturas.get(i)) ;
			} 
		}
		this.facturas=new ArrayList<Matricula>();
		this.facturas=facturasPendientes;
		this.facturasPagadas=false;
		this.facturasPendientes=true;
		
}
	
	public String factura(String total, int factid) {
		System.out.println(total);
		return "pagoFactura?faces-redirect=true&total="+total+"&id="+cedula1+"&factura="+factid;
	}
	
	public void loadDetalle(int id) {
		System.out.println(id);
		this.facDetalle= facturaON.buscar(id);
		System.out.println(this.facDetalle);
		
	}
	

	
	


}
