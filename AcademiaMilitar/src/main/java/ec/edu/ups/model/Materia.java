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
	
	@OneToOne
	@JoinColumn(name = "gru_id")
    private Matricula matricula;
	
	@OneToOne
	@JoinColumn(name = "doc_id")
    private Docente docente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "gru_id")
    private List<Grupo> grupos;

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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public void addGrupo(Grupo gru) {
		if(grupos == null)
			grupos = new ArrayList<Grupo>();
			
		grupos.add(gru);		
	}
    
}
