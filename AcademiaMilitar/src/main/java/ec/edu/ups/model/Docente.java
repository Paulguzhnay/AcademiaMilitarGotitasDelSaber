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
@Table(name = "TBL_Docente")
public class Docente implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private int id;
	@Column(name = "doc_titulo")
	private String titulo;
	@Column(name = "doc_gradoTitulo")
    private String gradoTiulo;
	@Column(name = "doc_especializacion")
    private String especializacion;
	
	@OneToOne
	@JoinColumn(name = "per_cedula")
    private Persona persona;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "log_id")
    private IniciarSesion iniciarSesion;
	
	

    public IniciarSesion getIniciarSesion() {
		return iniciarSesion;
	}

	public void setIniciarSesion(IniciarSesion iniciarSesion) {
		this.iniciarSesion = iniciarSesion;
	}

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

	@Override
	public String toString() {
		return "Docente [id=" + id + ", titulo=" + titulo + ", gradoTiulo=" + gradoTiulo + ", especializacion="
				+ especializacion + ", persona=" + persona + ", iniciarSesion=" + iniciarSesion + "]";
	}


}
