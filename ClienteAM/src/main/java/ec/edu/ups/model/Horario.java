package ec.edu.ups.model;

import java.io.Serializable;

public class Horario implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private int id;
	private String dia;
    private String hora;
    private EspacioFisico espacio;
    private Grupo grupo;

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public EspacioFisico getEspacio() {
        return espacio;
    }

    public void setEspacio(EspacioFisico espacio) {
        this.espacio = espacio;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
}
