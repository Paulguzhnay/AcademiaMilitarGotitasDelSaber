package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.Materia;

public interface MateriaONRemote {

public void insertar(Materia p) throws Exception;
	
	public List<Materia> getMaterias();
	
}
