package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
