package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.MateriaDAO;
import ec.edu.ups.model.Materia;

@Stateless
public class MateriaON implements MateriaONRemote, MateriaONLocal {

	@Inject
	private MateriaDAO daoMateria;
	
	public void insertar(Materia p) throws Exception{
		daoMateria.insert(p);
	}
	
	public List<Materia> getMaterias(){
		
		
		return daoMateria.getList();
	}
	
	public List<Materia> getMateriasCarrera(int nivel, int ofeID){
		
		
		
		return daoMateria.getListMaterias(nivel, ofeID);
	}
	
}
