package ec.edu.ups.business;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.FacturaDAO;
import ec.edu.ups.model.*;

@Stateless
public class FacturaON implements FacturaONRemote, FacturaONLocal{

	
	
	@Inject
	private FacturaDAO daoFactura;
	
	public void insertar(Factura  p) throws Exception  {
		daoFactura.insert(p);
	}
	
	public List <Factura> getFacturas(){
		return daoFactura.getList();
	}
	
	public void actualizar(Factura f) {
		daoFactura.update(f);
	}
	
	public Factura buscar(int id) {
		return daoFactura.read(id);
	}
	
}
