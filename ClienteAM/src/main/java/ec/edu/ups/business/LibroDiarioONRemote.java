package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.LibroDiario;

public interface LibroDiarioONRemote {
	public void insertar(LibroDiario lib) throws Exception;
	public List <LibroDiario> getLibro();
}
