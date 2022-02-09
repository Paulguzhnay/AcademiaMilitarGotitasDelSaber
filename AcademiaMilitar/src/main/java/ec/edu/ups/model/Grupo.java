package ec.edu.ups.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBL_Grupo")
public class Grupo implements Serializable{
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gru_id")
	private int id;
	@Column(name = "gru_numeroGrupo")
	private int numeroGrupo;
	@Column(name = "gru_nivel")
    private int nivel;
	
	@ManyToOne
	@JoinColumn(name = "doc_id")
    private Docente docente;
	@ManyToOne
	@JoinColumn(name = "mate_id")
    private Materia materia;
	
	@ManyToOne
	@JoinColumn(name = "hor_id")
    private Horario horario;
    
	@Transient
	private boolean seleccionado;

    public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", numeroGrupo=" + numeroGrupo + ", nivel=" + nivel + ", docente=" + docente
				+ ", materia=" + materia + ", horario=" + horario + ", seleccionado=" + seleccionado + "]";
	}


	
	
}
