package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.Materia;

@Remote
public interface MateriaONRemote {

public void insertar(Materia p) throws Exception;
	
	public List<Materia> getMaterias();
	
}
