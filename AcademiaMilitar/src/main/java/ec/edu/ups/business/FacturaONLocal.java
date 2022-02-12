package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;


import ec.edu.ups.model.*;

@Local
public interface FacturaONLocal {

	public void insertar(Factura  p) throws Exception;	
	public List <Factura> getFacturas();
	public void actualizar(Factura f) ;
	public Factura buscar(int id);
}
