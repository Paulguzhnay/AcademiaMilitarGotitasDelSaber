package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;


public class EspacioFisico implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombreEdificio;
    private int numeroAula;
	private List<EspacioFisico> espacioFisico;
	private Grupo grupo;

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

	public List<EspacioFisico> getEspacioFisico() {
		return espacioFisico;
	}

	public void setEspacioFisico(List<EspacioFisico> espacioFisico) {
		this.espacioFisico = espacioFisico;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
        
}
