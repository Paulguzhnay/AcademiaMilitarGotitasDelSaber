package ec.edu.ups.business;

import java.util.List;

import javax.inject.Inject;

import ec.edu.ups.dao.HorarioDAO;
import ec.edu.ups.model.Horario;

public class HorarioON implements HorarioONLocal,HorarioONRemote{
	@Inject
	private HorarioDAO daoHorario;
	
	public void insertar(Horario h) throws Exception  {
		daoHorario.insert(h);
	}
	
	public List <Horario> getHorario(){
		return daoHorario.getList();
	}
}
