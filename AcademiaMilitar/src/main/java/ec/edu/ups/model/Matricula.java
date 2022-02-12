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

@Entity
@Table(name = "TBL_Matricula")
public class Matricula implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matri_id")
	private int id;
	
	@Column(name = "matri_nivel")
	private int nivel;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "est_id")
    private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "ofe_id")
    private OfertaAcademica ofertaAcademica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fact_id")
    private Factura factura;
	

    public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
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
    
   
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public OfertaAcademica getOfertaAcademica() {
        return ofertaAcademica;
    }

    public void setOfertaAcademica(OfertaAcademica ofertaAcademica) {
        this.ofertaAcademica = ofertaAcademica;
    }

	
        
}
