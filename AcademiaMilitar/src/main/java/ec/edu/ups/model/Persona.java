package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Persona")
public class Persona implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "per_cedula")
    private String cedula;
	
	@Column(name = "per_nombres")
    private String nombres;
	@Column(name = "per_apellidos")
    private String apellidos;
	
	@Column(name = "per_correoPersonal")
    private String correoPersonal;
	@Column(name = "per_genero")
    private String genero;
	@Column(name = "per_direccion")
    private String direccion;
	@Column(name = "per_celular")
    private String celular;
	


	
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

   

    public String getCorreoPersonal() {
		return correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correoPersonal="
				+ correoPersonal + ", genero=" + genero + ", direccion=" + direccion + ", celular=" + celular + "]";
	}

}

