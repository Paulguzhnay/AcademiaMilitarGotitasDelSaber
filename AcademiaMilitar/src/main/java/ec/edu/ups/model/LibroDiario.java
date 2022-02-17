package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "TBL_LibroDiario")
public class LibroDiario implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lib_id")
	private int id;
	@Column(name = "lib_fecha")
	private Date fecha;
	@Column(name = "lib_valorTotal")
    private double valorTotal;
	

    public Date getFecha() {
        return fecha;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

	@Override
	public String toString() {
		return "LibroDiario [id=" + id + ", fecha=" + fecha + ", valorTotal=" + valorTotal + "]";
	}

    
    
}
