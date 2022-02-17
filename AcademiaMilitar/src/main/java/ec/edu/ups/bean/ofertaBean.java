package ec.edu.ups.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.OfertaAcademicaONLocal;
import ec.edu.ups.business.PersonaONLocal;
import ec.edu.ups.model.OfertaAcademica;
import ec.edu.ups.model.Persona;

@Named
@RequestScoped
public class ofertaBean {
	
	@Inject
	OfertaAcademicaONLocal ofertaON;
	
	OfertaAcademica ofertaAcademica = new OfertaAcademica();
	
	private List<OfertaAcademica> ofertas;
	
	
	public ofertaBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		this.loadOferta();
	}
	
	public OfertaAcademica getOfertaAcademica() {
		return ofertaAcademica;
	}

	public void setOfertaAcademica(OfertaAcademica ofertaAcademica) {
		this.ofertaAcademica = ofertaAcademica;
	}

	public List<OfertaAcademica> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<OfertaAcademica> ofertas) {
		this.ofertas = ofertas;
	}

	public void loadOferta() {
		this.ofertas = ofertaON.getOfertaAcademicas();
	}
}