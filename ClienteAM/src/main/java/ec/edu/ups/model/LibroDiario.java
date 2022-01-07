package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;


public class LibroDiario implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;
    private double valorTotal;
    private Factura factura;

    public Date getFecha() {
        return fecha;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
}
