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

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + "]";
	}

    
    
}
