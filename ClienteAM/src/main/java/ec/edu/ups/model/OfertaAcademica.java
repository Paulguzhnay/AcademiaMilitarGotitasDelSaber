package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;


public class OfertaAcademica implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombreCarrera;
    private int ciclos;
    private String modalidad;
    private MallaCurricular mallaCurricular;
    private List<Matricula> matriculas;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public MallaCurricular getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(MallaCurricular mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
       
}
