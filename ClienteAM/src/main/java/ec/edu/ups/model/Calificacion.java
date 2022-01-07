package ec.edu.ups.model;

import java.io.Serializable;

public class Calificacion implements Serializable {
    
	private static final long serialVersionUID = 1L;
    private int id;
    private double notaObtenida;
	private Grupo grupo;
    private Estudiante estudiante;
    

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
