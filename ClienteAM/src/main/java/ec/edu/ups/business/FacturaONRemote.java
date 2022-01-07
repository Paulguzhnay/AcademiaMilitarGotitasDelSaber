package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.*;

public interface FacturaONRemote {

	public void insertar(Factura  p) throws Exception;	
	public List <Factura> getFacturas();
}
