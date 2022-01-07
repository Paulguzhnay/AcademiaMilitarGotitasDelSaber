package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;

public class Inscripcion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String periodoLectivo;
    private String carrera;
    private String modalidad;
    private String jornada;
    private Date fechaRegistro;
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
