package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Horario")
public class Horario implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hor_id")
	private int id;
	@Column(name = "hor_dia")
	private String dia;
	@Column(name = "hor_hora")
    private String hora;
	
	@OneToOne
	@JoinColumn(name = "esp_id")
    private EspacioFisico espacio;
	@OneToOne
	@JoinColumn(name = "gru_id")
    private Grupo grupo;

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public EspacioFisico getEspacio() {
        return espacio;
    }

    public void setEspacio(EspacioFisico espacio) {
        this.espacio = espacio;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
}
