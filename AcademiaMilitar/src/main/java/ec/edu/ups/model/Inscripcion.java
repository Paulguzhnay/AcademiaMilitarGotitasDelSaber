package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Inscripcion")
public class Inscripcion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ins_id")
	private int id;
	@Column(name = "ins_periodoLectivo")
    private String periodoLectivo;
	@Column(name = "ins_carrera")
    private String carrera;
	@Column(name = "ins_modalidad")
    private String modalidad;
	@Column(name = "ins_jornada")
    private String jornada;
	@Column(name = "ins_fechaRegistro")
    private Date fechaRegistro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "per_cedula" )
    private Persona persona;

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
	
	public String getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(String periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
