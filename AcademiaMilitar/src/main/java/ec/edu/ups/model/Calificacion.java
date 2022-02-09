package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Calificacion")
public class Calificacion implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cal_id")
    private int id;
	@Column(name = "cal_notaObtenida")
    private double notaObtenida;
	
	@ManyToOne
	@JoinColumn(name = "mat_id")
	private Materia materia;
	

	@ManyToOne
	@JoinColumn(name = "est_id")
    private Estudiante estudiante;
    

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public double getNotaObtenida() {
        return notaObtenida;
    }

    public void setNotaObtenida(double notaObtenida) {
        this.notaObtenida = notaObtenida;
    }
    
}
