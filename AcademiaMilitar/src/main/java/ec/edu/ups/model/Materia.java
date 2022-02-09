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
@Table(name = "TBL_Materia")
public class Materia implements Serializable{
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mate_id")
	private int id;
	@Column(name = "mate_nombre")
    private String nombre;
	@Column(name = "mate_nivel")
    private int nivel;
	
	@ManyToOne
	@JoinColumn(name = "ofe_id")
    private OfertaAcademica ofertaAcademica;
	
	@Transient
	private boolean seleccionado;

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + ", ofertaAcademica=" + ofertaAcademica
				+ ", seleccionado=" + seleccionado + "]";
	}
    
}
