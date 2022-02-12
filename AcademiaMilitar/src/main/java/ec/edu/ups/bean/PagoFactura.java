package ec.edu.ups.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.FacturaONLocal;
import ec.edu.ups.model.Factura;

@Named
@ViewScoped
public class PagoFactura implements Serializable {

	@Inject
	private FacturaONLocal facturaON;
	
	private String total;
	private String cedula;
	private int idFactura;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String pagarFactura() {
		
		System.out.println("facturaID"+idFactura);
		
		Factura fact=new Factura();
		fact=facturaON.buscar(idFactura);
		fact.setEstado(true);
		facturaON.actualizar(fact);	
		return "estudianteCuentas?faces-redirect=true?&id="+this.cedula;
	}
	
public String cancelar() {
		
		
		return "estudianteCuentas?faces-redirect=true?&id="+this.cedula;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	

}
