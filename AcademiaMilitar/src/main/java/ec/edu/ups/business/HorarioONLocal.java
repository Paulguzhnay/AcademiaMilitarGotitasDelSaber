package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.model.Horario;

@Local
public interface HorarioONLocal {
	
	public void insertar(Horario h) throws Exception ;
	
	public List <Horario> getHorario(); 
}
