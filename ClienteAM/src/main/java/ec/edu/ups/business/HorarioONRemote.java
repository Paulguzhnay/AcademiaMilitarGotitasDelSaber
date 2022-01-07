package ec.edu.ups.business;

import java.util.List;

import ec.edu.ups.model.Horario;

public interface HorarioONRemote {
	
	public void insertar(Horario h) throws Exception ;
	
	public List <Horario> getHorario(); 
}
