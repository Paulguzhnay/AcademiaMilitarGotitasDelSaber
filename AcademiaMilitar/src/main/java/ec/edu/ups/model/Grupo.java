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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne
	@JoinColumn(name = "doc_id")
    private Docente docente;
	@OneToOne
	@JoinColumn(name = "mate_id")
    private Materia materia;
    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mat_id")
    private List<Matricula> matriculas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "esp_id")
    private List<EspacioFisico> espaciosFisicos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hor_id")
    private List<Horario> horarios;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cal_id")
    private List<Calificacion> calificaciones;
	
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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<EspacioFisico> getEspaciosFisicos() {
		return espaciosFisicos;
	}

	public void setEspaciosFisicos(List<EspacioFisico> espaciosFisicos) {
		this.espaciosFisicos = espaciosFisicos;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
    
	public void addMatricula(Matricula mat) {
		if(matriculas == null)
			matriculas = new ArrayList<Matricula>();
			
		matriculas.add(mat);		
	}
	
	public void addCalificaciones(Calificacion cal) {
		if(calificaciones == null)
			calificaciones = new ArrayList<Calificacion>();
			
		calificaciones.add(cal);		
	}
	
	public void addEspacioFisico(EspacioFisico esp) {
		if(espaciosFisicos == null)
			espaciosFisicos = new ArrayList<EspacioFisico>();
			
		espaciosFisicos.add(esp);		
	}
	
	public void addHorario(Horario hor) {
		if(horarios == null)
			horarios = new ArrayList<Horario>();
			
		horarios.add(hor);		
	}
	
}
