package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;

public class MallaCurricular implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private int id;
	private int nivel;
    private String asignatura;
    private int horas;
    private List<OfertaAcademica> ofertasAcademicas;
	
	public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

	public List<OfertaAcademica> getOfertasAcademicas() {
		return ofertasAcademicas;
	}

	public void setOfertasAcademicas(List<OfertaAcademica> ofertasAcademicas) {
		this.ofertasAcademicas = ofertasAcademicas;
	}
    
}
