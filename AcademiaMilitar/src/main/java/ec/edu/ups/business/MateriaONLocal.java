package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Materia;

@Local
public interface MateriaONLocal {
	
public void insertar(Materia p) throws Exception;
	
	public List<Materia> getMaterias();

}

