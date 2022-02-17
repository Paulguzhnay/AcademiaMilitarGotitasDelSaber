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
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MallaCurricular")
public class MallaCurricular implements Serializable{
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mall_id")
	private int id;
	@Column(name = "mall_nivel")
	private int nivel;
	@Column(name = "mall_asignatura")
    private String asignatura;
	@Column(name = "mall_horas")
    private int horas;

	@ManyToOne
	@JoinColumn(name = "ofe_id")
    private OfertaAcademica ofertaAcademica = new OfertaAcademica();
	
	public OfertaAcademica getOfertaAcademica() {
		return ofertaAcademica;
	}

	public void setOfertaAcademica(OfertaAcademica ofertaAcademica) {
		this.ofertaAcademica = ofertaAcademica;
	}

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

	@Override
	public String toString() {
		return "MallaCurricular [id=" + id + ", nivel=" + nivel + ", asignatura=" + asignatura + ", horas=" + horas
				+ ", ofertaAcademica=" + ofertaAcademica + "]";
	}

	
    
}
