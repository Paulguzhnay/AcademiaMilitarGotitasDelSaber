package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name = "per_fechaNacimiento")
    private Date fechaNacimiento;
	@Column(name = "per_genero")
    private String genero;
	@Column(name = "per_direccion")
    private String direccion;
	@Column(name = "per_celular")
    private String celular;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_id")
    private Docente docentes;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "est_id")
    private Estudiante estudiantes;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ins_id")
    private Inscripcion inscripciones;


	
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

	public Docente getDocentes() {
		return docentes;
	}

	public void setDocentes(Docente docentes) {
		this.docentes = docentes;
	}

	public Estudiante getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Estudiante estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Inscripcion getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Inscripcion inscripciones) {
		this.inscripciones = inscripciones;
	}
    
    
}
