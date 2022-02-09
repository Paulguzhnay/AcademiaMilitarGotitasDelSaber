package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.FacturaONLocal;
import ec.edu.ups.business.MatriculaONLocal;
import ec.edu.ups.model.Factura;
import ec.edu.ups.model.Matricula;

@Named
@ViewScoped
public class EstudainteCuentasBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private MatriculaONLocal matriculaON;
	
	private List<Matricula> facturas=new ArrayList<Matricula>();

	public List<Matricula> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Matricula> facturas) {
		this.facturas = facturas;
	}
	
	
	public void loadFacturas() {
		
	}



}
