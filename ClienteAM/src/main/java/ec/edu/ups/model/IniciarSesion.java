package ec.edu.ups.model;

import java.io.Serializable;

public class IniciarSesion implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String usuario;
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
