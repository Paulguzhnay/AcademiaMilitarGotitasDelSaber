package ec.edu.ups.model;

import java.io.Serializable;
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
@Table(name = "TBL_OfertaAcademica")
public class OfertaAcademica implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ofe_id")
	private int id;
	@Column(name = "ofe_nombreCarrera")
	private String nombreCarrera;
	@Column(name = "ofe_ciclos")
    private int ciclos;
	@Column(name = "ofe_modalidad")
    private String modalidad;
	
	@OneToOne
	@JoinColumn(name = "mall_id")
    private MallaCurricular mallaCurricular;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mat_id")
    private List<Matricula> matriculas;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public MallaCurricular getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(MallaCurricular mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
       
}
