package ec.edu.ups.view;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.business.InscripcionONRemote;
import ec.edu.ups.business.PersonaONRemote;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Persona;



public class ventanaPruebas {
	
	private PersonaONRemote personaRemote;
	private InscripcionONRemote inscripcionesRemote;
	
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demo");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demo");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/AcademiaMilitar/CalificacionON!ec.edu.ups.business.CalificacionONRemote";  
              
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
             
            final String lookupName2 = "ejb:/AcademiaMilitar/MallaCurricularON!ec.edu.ups.business.MallaCurricularONRemote";  
            
            //this.cliRemoto = (ClientesONRemoto) context.lookup(lookupName2);  
            
            final String lookupName3 = "ejb:/AcademiaMilitar/HorarioON!ec.edu.ups.business.HorarioONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
             
            final String lookupName4 = "ejb:/AcademiaMilitar/InscripcionON!ec.edu.ups.business.InscripcionONRemote";  
            
            this.inscripcionesRemote = (InscripcionONRemote) context.lookup(lookupName4);  
            
            final String lookupName5 = "ejb:/AcademiaMilitar/espacioFisicoON!ec.edu.ups.business.espacioFisicoONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
             
            final String lookupName6 = "ejb:/AcademiaMilitar/EstudianteON!ec.edu.ups.business.EstudianteONRemote";  
            
            //this.cliRemoto = (ClientesONRemoto) context.lookup(lookupName2);  
            final String lookupName7 = "ejb:/AcademiaMilitar/LibroDiarioON!ec.edu.ups.business.LibroDiarioONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
             
            final String lookupName8 = "ejb:/AcademiaMilitar/IniciarSesionON!ec.edu.ups.business.IniciarSesionONRemote";  
            
            //this.cliRemoto = (ClientesONRemoto) context.lookup(lookupName2);  
            final String lookupName9 = "ejb:/AcademiaMilitar/MatriculaON!ec.edu.ups.business.MatriculaONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
             
            final String lookupName10 = "ejb:/AcademiaMilitar/FacturaON!ec.edu.ups.business.FacturaONRemote";  
         
            
            //this.cliRemoto = (ClientesONRemoto) context.lookup(lookupName2);  
            final String lookupName11 = "ejb:/AcademiaMilitar/GrupoON!ec.edu.ups.business.GrupoONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
             
            final String lookupName12 = "ejb:/AcademiaMilitar/DocenteON!ec.edu.ups.business.DocenteONRemote";  
            
            //this.cliRemoto = (ClientesONRemoto) context.lookup(lookupName2);  
            final String lookupName13 = "ejb:/AcademiaMilitar/PersonaON!ec.edu.ups.business.PersonaONRemote";  
            
            this.personaRemote = (PersonaONRemote) context.lookup(lookupName13);  
             
            final String lookupName14 = "ejb:/AcademiaMilitar/MateriaON!ec.edu.ups.business.MateriaONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName);  
            
            final String lookupName15 = "ejb:/AcademiaMilitar/OfertaAcademicaON!ec.edu.ups.business.OfertaAcademicaONRemote";  
            
            //this.calRemote = (CalculadoraONRemote) context.lookup(lookupName); 
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ventanaPruebas v = new ventanaPruebas();
		v.conectar();
		v.Crear();
	}
	
	public void Crear() {
		Persona p = new Persona();
		p.setCedula("0105599828");
		p.setNombres("Danny Gustavo");
		p.setApellidos("Yunga Yunga");
		p.setCelular("0984709368");
		p.setDireccion("ECU 911");
		p.setFechaNacimiento(new Date());
		p.setGenero("Hombre");
		
		
		//PerOn.insertar(p);
		
		Inscripcion i = new Inscripcion();
		i.setCarrera("Computación");
		i.setFechaRegistro(new Date());
		i.setJornada("Matutina");
		i.setModalidad("Presencial");
		i.setPeriodoLectivo("Periodo 59");
		i.setPersona(p);
		
		try {
			inscripcionesRemote.insertar(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Insertado");
	}

}
