package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.LibroDiario;

@Remote
public interface LibroDiarioONRemote {
	public void insertar(LibroDiario lib) throws Exception;
	public List <LibroDiario> getLibro();
}
