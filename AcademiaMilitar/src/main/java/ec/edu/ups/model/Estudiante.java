package ec.edu.ups.model;

import java.io.Serializable;
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
@Table(name = "TBL_Estudiante")
public class Estudiante implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
	private int id;
	@Column(name = "est_cicloCursando")
    private int cicloCursando;
	
	@OneToOne
	@JoinColumn(name = "per_cedula")
    private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cal_id")
    private List<Calificacion> calificaciones;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mat_id")
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
