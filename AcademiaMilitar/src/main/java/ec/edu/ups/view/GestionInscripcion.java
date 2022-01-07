package ec.edu.ups.view;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.business.InscripcionONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Persona;

/**
 * Servlet implementation class GestionInscripcion
 */
@WebServlet("/GestionInscripcion")
public class GestionInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private InscripcionONLocal InsON;
	private PersonaONLocal PerOn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Persona p = new Persona();
		p.setCedula("0105599823");
		p.setNombres("Joseph Nicolas");
		p.setApellidos("Reinoso Villa");
		p.setCelular("0984709368");
		p.setDireccion("Monay");
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
		
		InsON.insertar(i);
	
		System.out.println("Insertado");
				

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
