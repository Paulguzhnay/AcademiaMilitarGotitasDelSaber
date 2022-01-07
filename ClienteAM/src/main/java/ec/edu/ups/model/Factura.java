package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Factura implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private Date fecha;
    private String detalle;
    private String metodoPago;
    private double subtotal;
    private double iva;
    private double descuento;
    private double total;
    private List<LibroDiario> libroDiarios;
	
    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
	
	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

	public List<LibroDiario> getLibroDiarios() {
		return libroDiarios;
	}

	public void setLibroDiarios(List<LibroDiario> libroDiarios) {
		this.libroDiarios = libroDiarios;
	}
        
}
