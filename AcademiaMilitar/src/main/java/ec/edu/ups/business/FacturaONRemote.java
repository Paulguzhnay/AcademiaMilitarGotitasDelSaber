package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.*;

@Remote
public interface FacturaONRemote {

	public void insertar(Factura  p) throws Exception;	
	public List <Factura> getFacturas();
}
