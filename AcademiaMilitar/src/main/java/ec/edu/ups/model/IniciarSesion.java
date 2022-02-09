package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_IniciarSesion")
public class IniciarSesion implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ini_id")
	private int id;
	@Column(name = "ini_usuario")
	private String usuario;
	@Column(name = "ini_contrasenia")
    private String contrasenia;
	
	@OneToOne
	@JoinColumn(name = "doc_id")
    private Docente docente;
	
	@OneToOne
	@JoinColumn(name = "ins_id")
    private Inscripcion inscripcion;

    public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
	
	public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }
        
}
