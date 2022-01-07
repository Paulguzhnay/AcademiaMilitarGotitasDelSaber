package ec.ups.edu.AcademiaMilitar.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ec.edu.ups.model.Calificacion;
import ec.edu.ups.model.Docente;
import ec.edu.ups.model.EspacioFisico;
import ec.edu.ups.model.Estudiante;
import ec.edu.ups.model.Factura;
import ec.edu.ups.model.Grupo;
import ec.edu.ups.model.Horario;
import ec.edu.ups.model.IniciarSesion;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.LibroDiario;
import ec.edu.ups.model.MallaCurricular;
import ec.edu.ups.model.Materia;
import ec.edu.ups.model.Matricula;
import ec.edu.ups.model.OfertaAcademica;
import ec.edu.ups.model.Persona;

public class TestPruebas {

	@Test
	public void testCalificacion() {
		Calificacion calificacion = new Calificacion();
		calificacion.setId(1);
		calificacion.setNotaObtenida(98.0);
		
		Grupo grupo = new Grupo();
		grupo.setId(1);
		calificacion.setGrupo(grupo);
		
		Estudiante estudiante = new Estudiante();
		estudiante.setId(1);
		calificacion.setEstudiante(estudiante);
		
		assertTrue(calificacion.getId()==1);
		assertTrue(calificacion.getNotaObtenida()==98.0);
		assertTrue(calificacion.getGrupo()==grupo);
		assertTrue(calificacion.getEstudiante()==estudiante);
		
	}
	
    @Test
    public void testCrearDocente() {
    	List<Grupo> listGrupo = new ArrayList<Grupo>();
    	List<Materia> listMateria = new ArrayList<Materia>();
    	Docente docente = new Docente();
    	Persona persona = new Persona();
    	Grupo grupo = new Grupo();
    	Materia materia = new Materia();
    	
    	persona.setCedula("1234567896");
    	grupo.setId(1);
    	listGrupo.add(grupo);
    	materia.setId(1);
    	listMateria.add(materia);
    	docente.setId(1);
    	
    	
    	docente.setTitulo("Ingeniero");
    	docente.setGradoTiulo("Cuarto Nivel");
    	docente.setEspecializacion("CyberSeguridad");
    	docente.setPersona(persona);
    	docente.setGrupos(listGrupo);
    	docente.setMateria(listMateria);
    	
    	assertTrue(docente.getId()==1);
    	assertTrue(docente.getTitulo()=="Ingeniero");
    	assertTrue(docente.getGradoTiulo()=="Cuarto Nivel");
    	assertTrue(docente.getEspecializacion()=="CyberSeguridad");
    	assertTrue(docente.getGrupos()==listGrupo);
    	assertTrue(docente.getMateria()==listMateria);
    }
    @Test
	public void testEspaciosFisicos() {
		 EspacioFisico espacioFisico = new EspacioFisico();
		 espacioFisico.setId(1);
		 espacioFisico.setNombreEdificio("Mario Rizzini");
		 espacioFisico.setNumeroAula(24);
		 
		 Grupo grupo = new Grupo();
		 grupo.setId(1);
		 espacioFisico.setGrupo(grupo);
		 
		 assertTrue(espacioFisico.getId()==1);
		 assertTrue(espacioFisico.getNombreEdificio()=="Mario Rizzini");
		 assertTrue(espacioFisico.getNumeroAula()==24);
		 assertTrue(espacioFisico.getGrupo()==grupo);
	}
    
    @Test
    public void testEstudiante() {
    	Estudiante estudiante = new Estudiante();
    	Persona persona = new Persona();
    	List<Calificacion> listCalificacion = new ArrayList<Calificacion>();
    	List<Matricula>listMatricula= new ArrayList<Matricula>();
    	Calificacion calificacion = new Calificacion();
    	Matricula matricula = new Matricula();
    	
    	
    	estudiante.setId(1);
    	estudiante.setCicloCursando(5);
    	persona.setCedula("0123456789");
    	calificacion.setId(1);
    	listCalificacion.add(calificacion);
    	matricula.setId(1);
    	listMatricula.add(matricula);
    	
    	
    	//ASSERT
    	
    	assertTrue(estudiante.getId()==1);
    	assertTrue(estudiante.getCicloCursando()==5);
    	assertTrue(estudiante.getPersona()==persona);
    	assertTrue(estudiante.getCalificaciones()==calificacion);
    	assertTrue(estudiante.getMatriculas()==matricula);
    }
    
    
    
    @Test
	public void testFactura() {
		List<LibroDiario> libroDiario = new ArrayList<LibroDiario>();
		Date fecha = new Date();
		Factura factura = new Factura();
		factura.setId(1);
		factura.setCedula("0105599823");
		factura.setNombre("Joseph Reinoso");
		factura.setCorreo("joreinoso39@gmail.com");
		factura.setTelefono("4040801");
		factura.setDireccion("Monay");
		factura.setFecha(fecha);
		factura.setDetalle("Matricula Periodo 59");
		factura.setIva(120);
		factura.setSubtotal(1080);
		factura.setTotal(1200);
		
		LibroDiario libroDiarios = new LibroDiario();
		libroDiarios.setId(1);
		libroDiario.add(libroDiarios);
		
		assertTrue(factura.getId()==1);
		assertTrue(factura.getCedula()=="0105599823");
		assertTrue(factura.getNombre()=="Joseph Reinoso");
		assertTrue(factura.getCorreo()=="joreinoso39@gmail.com");
		assertTrue(factura.getTelefono()=="4040801");
		assertTrue(factura.getDireccion()=="Monay");
		assertTrue(factura.getFecha()==fecha);
		assertTrue(factura.getDetalle()=="Matricula Periodo 59");
		assertTrue(factura.getIva()==120);
		assertTrue(factura.getSubtotal()==1080);
		assertTrue(factura.getTotal()==1200);
		assertTrue(factura.getLibroDiarios()==libroDiario);
	}
    
    
    
    @Test
    public void testGrupo() {
    	List<Matricula> listMatricula = new ArrayList<Matricula>();
    	List<EspacioFisico> listEspacioFisico = new ArrayList<EspacioFisico>();
    	List<Horario> listHorario = new ArrayList<Horario>();
    	List<Calificacion> listCalificacion = new ArrayList<Calificacion>();
    	
    	Grupo grupo = new Grupo();
    	Docente docente = new Docente();
    	Materia materia = new Materia();
    	Matricula matricula = new Matricula();
    	EspacioFisico espaciofisico= new EspacioFisico();
    	Horario horario = new Horario();
    	Calificacion calificacion= new Calificacion();
    	
    	grupo.setId(1);
    	grupo.setNumeroGrupo(5);
    	grupo.setNivel(4);
    	
    	docente.setId(1);
    	grupo.setDocente(docente);
    	materia.setId(1);
    	grupo.setMateria(materia);
    	
    	//Listas
    	espaciofisico.setId(1);
    	listEspacioFisico.add(espaciofisico);
    	matricula.setId(1);
    	listMatricula.add(matricula);
    	horario.setId(1);
    	listHorario.add(horario);
    	calificacion.setId(1);
    	listCalificacion.add(calificacion);
    	
    	//Assert
    	assertTrue(grupo.getId()==1);
    	assertTrue(grupo.getNumeroGrupo()==5);
    	assertTrue(grupo.getNivel()==5);
    	assertTrue(grupo.getDocente()==docente);
    	assertTrue(grupo.getMateria()==materia);
    	assertTrue(grupo.getMatriculas()==matricula);
    	assertTrue(grupo.getEspaciosFisicos()==espaciofisico);
    	assertTrue(grupo.getHorarios()==horario);
    	assertTrue(grupo.getCalificaciones()==calificacion);
    	
    }
    
    
    @Test
	public void testHorario() {
		Horario horario = new Horario();
		horario.setId(1);
		horario.setHora("08H00 - 10H00");
		horario.setDia("Lunes");
		
		Grupo grupo = new Grupo();
		grupo.setId(1);
		horario.setGrupo(grupo);
		
		EspacioFisico espaciosFisico = new EspacioFisico();
		espaciosFisico.setId(1);
		horario.setEspacio(espaciosFisico);
		
		assertTrue(horario.getId()==1);
		assertTrue(horario.getHora()=="08H00 - 10H00");
		assertTrue(horario.getDia()=="Lunes");
		assertTrue(horario.getGrupo()==grupo);
		assertTrue(horario.getEspacio()==espaciosFisico);
	}
    
    @Test
    public void testIniciarSesion() {
    	IniciarSesion iniciarsesion = new IniciarSesion();
    	iniciarsesion.setId(1);
    	iniciarsesion.setUsuario("liomessi@est.ups.edu.ec");
    	iniciarsesion.setContrasenia("Argentina");
    	
    	assertTrue(iniciarsesion.getId()==1);
    	assertTrue(iniciarsesion.getUsuario()=="liomessi@est.ups.edu.ec");
    	assertTrue(iniciarsesion.getContrasenia()=="Argentina");
    }
    
    @Test
	public void testCrearInscripcion() {	
		Date fecha = new Date();
		
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCarrera("Computación");
		inscripcion.setFechaRegistro(fecha);
		inscripcion.setJornada("Matutina");
		inscripcion.setModalidad("Presencial");
		inscripcion.setPeriodoLectivo("Periodo 59");
		Persona p = new Persona();
		p.setCedula("0105599823");
		inscripcion.setPersona(p);
				
		assertEquals(inscripcion.getCarrera(),"Computacinscripcionon");
		assertEquals(inscripcion.getFechaRegistro(),fecha);
		assertEquals(inscripcion.getJornada(),"Matutina");
		assertEquals(inscripcion.getModalidad(),"Presencial");
		assertEquals(inscripcion.getPeriodoLectivo(),"Periodo 59");
		assertEquals(inscripcion.getPersona(),p);

	}
    
    @Test
    public void testLibroDiario() {
    	Date fecha = new Date();
    	LibroDiario librodiario= new LibroDiario();
    	
    	librodiario.setId(1);
    	librodiario.setFecha(fecha);
    	librodiario.setValorTotal(45.5);
    	
    	assertTrue(librodiario.getId()==1);
    	assertEquals(librodiario.getFecha(), fecha);
    	assertTrue(librodiario.getValorTotal()==45.5);

    }
    
    @Test 
    public void testMallaCurricular() {
    	List<OfertaAcademica> listOferta = new ArrayList<OfertaAcademica>();
    	OfertaAcademica ofertaacademica = new OfertaAcademica();
    	MallaCurricular mallacurricular = new MallaCurricular();
    	mallacurricular.setId(1);
    	mallacurricular.setNivel(5);
    	mallacurricular.setAsignatura("Ecuaciones Diferenciales");
    	mallacurricular.setHoras(100);
    	ofertaacademica.setId(1);
    	listOferta.add(ofertaacademica);
    	
    	assertTrue(mallacurricular.getId()==1);
    	assertTrue(mallacurricular.getNivel()==5);
    	assertTrue(mallacurricular.getAsignatura()=="Ecuaciones Diferenciales");
    	assertTrue(mallacurricular.getHoras()==100);
    	assertTrue(mallacurricular.getOfertasAcademicas()==listOferta);
    }
    

    
      @Test
    public void testMateria() {
    	List<Grupo> listGrupo = new ArrayList<Grupo>();
    
    	Matricula matricula = new Matricula();
    	Materia materia = new Materia();
    	Docente docente = new Docente();
    	Grupo grupo = new Grupo();
    	
    	materia.setId(1);
    	materia.setNombre("Ingenieria en Software");
    	materia.setNivel(5);
    	
    	matricula.setId(1);
    	docente.setId(1);
    	grupo.setId(1);
    	listGrupo.add(grupo);
    	
    	materia.setMatricula(matricula);
    	materia.setDocente(docente);
    	materia.setGrupos(listGrupo);
    	
    	
    	//Assert
    	assertTrue(false);
    	assertTrue(materia.getNivel()==1);
    	assertTrue(materia.getNombre()=="Ingenieria en Software");
    	assertTrue(materia.getNivel()==5);
    	assertTrue(materia.getDocente()==docente);
    	assertTrue(materia.getGrupos()==grupo);
    	assertTrue(materia.getGrupos()==listGrupo);
    }
   
     @Test
     public void testMatricula() {
    	 Matricula matricula = new Matricula();
    	 Grupo grupo = new Grupo();
    	 Estudiante estudiante = new Estudiante();
    	 OfertaAcademica ofertaacademica = new OfertaAcademica();
    	 Materia materia = new Materia();
    	 List<Materia>listmateria = new ArrayList<Materia>();
    	 
    	 
    	 matricula.setId(1);
    	grupo.setId(1);
    	estudiante.setId(1);
    	ofertaacademica.setId(1);
    	
    	materia.setId(1);
    	listmateria.add(materia);
    	
    	//Assert
    	
    	assertTrue(matricula.getId()==1);
    	assertTrue(matricula.getGrupo()==grupo);
    	assertTrue(matricula.getEstudiante()==estudiante);
    	assertTrue(matricula.getOfertaAcademica()==ofertaacademica);
    	assertTrue(matricula.getMaterias()==materia);
     }
     
     
     
     @Test
     public void testOfertaAcademica() {
    	 List<Matricula>listMatricula = new ArrayList<Matricula>();
    	 OfertaAcademica ofertaacademica = new OfertaAcademica();
    	 MallaCurricular mallacurricular = new MallaCurricular();
    	 Matricula matricula = new Matricula();
    	 
    	 
    	 ofertaacademica.setId(1);
    	 ofertaacademica.setNombreCarrera("Computacion");
    	 ofertaacademica.setCiclos(5);
    	 ofertaacademica.setModalidad("Presencial");
    	 mallacurricular.setId(1);
    	 matricula.setId(1);
    	 listMatricula.add(matricula);
    	 
    	 //Assert
    	 
    	 assertTrue(ofertaacademica.getId()==1);
    	 assertTrue(ofertaacademica.getNombreCarrera()=="Computacion");
    	 assertTrue(ofertaacademica.getCiclos()==5);
    	 assertTrue(ofertaacademica.getModalidad()=="Presencial");
    	 assertTrue(ofertaacademica.getMallaCurricular()==mallacurricular);
    	 assertTrue(ofertaacademica.getMatriculas()==listMatricula);
     }

    @Test
    public void testPersona() {
    	Date fecha = new Date();
    	Persona persona = new Persona();
    	Docente docente = new Docente();
    	Estudiante estudiante = new Estudiante();
    	Inscripcion inscripcion = new Inscripcion();
    	
 
    	persona.setCedula("1234567896");
    	persona.setNombres("Lionel");
    	persona.setApellidos("Messi");
    	persona.setFechaNacimiento(fecha);
    	persona.setDireccion("Argentina");
    	persona.setCelular("0987654321");
    	
    	docente.setId(1);
    	estudiante.setId(1);
    	inscripcion.setId(1);
    	
    	//Assert
    	assertTrue(persona.getCedula()=="1234567896");
    	assertTrue(persona.getNombres()=="Lionel");
    	assertTrue(persona.getApellidos()=="Messi");
    	assertTrue(persona.getFechaNacimiento()==fecha);
    	assertTrue(persona.getDireccion()=="Argentina");
    	assertTrue(persona.getCelular()=="0987654321");
    	assertTrue(persona.getDocentes()==docente);
    	assertTrue(persona.getEstudiantes()==estudiante);
    	assertTrue(persona.getInscripciones()==inscripcion);
    }

}
