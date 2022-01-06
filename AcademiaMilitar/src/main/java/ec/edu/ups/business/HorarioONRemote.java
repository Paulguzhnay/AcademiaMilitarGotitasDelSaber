package ec.edu.ups.business;

import java.util.List;

import javax.ejb.Remote;
import ec.edu.ups.model.Horario;

@Remote
public interface HorarioONRemote {
	
	public void insertar(Horario h) throws Exception ;
	
	public List <Horario> getHorario(); 
}
