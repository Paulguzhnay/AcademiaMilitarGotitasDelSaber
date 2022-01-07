package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;


public class Grupo implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int numeroGrupo;
    private int nivel;
    private Docente docente;
    private Materia materia;
    private List<Matricula> matriculas;
    private List<EspacioFisico> espaciosFisicos;
    private List<Horario> horarios;
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
    
}
