package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;

public class Docente implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
    private String gradoTiulo;
    private String especializacion;
    private Persona persona;
	private List<Grupo> grupos;
	private List<Materia> materia;
	

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGradoTiulo() {
        return gradoTiulo;
    }

    public void setGradoTiulo(String gradoTiulo) {
        this.gradoTiulo = gradoTiulo;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Materia> getMateria() {
		return materia;
	}

	public void setMateria(List<Materia> materia) {
		this.materia = materia;
	}
        
}
