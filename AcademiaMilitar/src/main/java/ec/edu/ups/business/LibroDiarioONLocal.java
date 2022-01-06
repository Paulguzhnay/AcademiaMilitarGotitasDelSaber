package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.LibroDiario;

@Local
public interface LibroDiarioONLocal {
	public void insertar(LibroDiario lib) throws Exception;
	public List <LibroDiario> getLibro();
}
