package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;

public class Estudiante implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private int id;
    private int cicloCursando;
    private Persona persona;
    private List<Calificacion> calificaciones;
    private List<Matricula> matriculas;
	

    public int getCicloCursando() {
        return cicloCursando;
    }

    public void setCicloCursando(int cicloCursando) {
        this.cicloCursando = cicloCursando;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
    
}
