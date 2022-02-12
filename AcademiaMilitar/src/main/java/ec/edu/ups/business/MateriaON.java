package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.MateriaDAO;
import ec.edu.ups.model.MallaCurricular;
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
	

	public Materia obtenerDatosAsignatura(int id) {
		System.out.println("***************************************************************************************************");
		System.out.println("ESTE ES EL ID "+id);
		return daoMateria.read(id);
		
	}

	public void eliminarAsignatura(int id) {
		daoMateria.delete(id);
	}
	
	public void guardar(Materia mall) throws Exception  {
		if(daoMateria.read(mall.getId())==null) {
			System.out.println("dao recibe"+daoMateria.read(mall.getId()));
			daoMateria.insert(mall);			
		}
		else {
			daoMateria.update(mall);			
		}
	}

}
