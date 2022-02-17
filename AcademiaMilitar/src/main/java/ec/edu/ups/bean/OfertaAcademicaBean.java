package ec.edu.ups.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.MallaCurricularONLocal;
import ec.edu.ups.business.OfertaAcademicaONLocal;
import ec.edu.ups.model.MallaCurricular;
import ec.edu.ups.model.OfertaAcademica;

@Named
@RequestScoped
public class OfertaAcademicaBean {
	
	@Inject
	private OfertaAcademicaONLocal ofertON;
	
	@Inject
	private MallaCurricularONLocal mallOn;
	
	private int codigo;
	
	private OfertaAcademica oferta = new OfertaAcademica();
	private MallaCurricular malla = new MallaCurricular();
	
	List<MallaCurricular> listMalla;
	List<OfertaAcademica> listOferta;
	
	@PostConstruct
	public void init() {
		this.loadOfertas();
	}
	

	public OfertaAcademica getOferta() {
		return oferta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<OfertaAcademica> getListOferta() {
		return listOferta;
	}

	public void setListOferta(List<OfertaAcademica> listOferta) {
		this.listOferta = listOferta;
	}

	public void setOferta(OfertaAcademica oferta) {
		this.oferta = oferta;
	}

	public MallaCurricular getMalla() {
		return malla;
	}

	public void setMalla(MallaCurricular malla) {
		this.malla = malla;
	}

	public List<MallaCurricular> getListMalla() {
		return listMalla;
	}

	public void setListMalla(List<MallaCurricular> listMalla) {
		this.listMalla = listMalla;
	}
	
	public void guardar() {
		System.out.println("Guardando Oferta Academica");
		try {
			ofertON.insertar(this.oferta);
			loadOfertas();
			//clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar2() {
		System.out.println("Guardando Malla");
		try {
			mallOn.insertar(this.malla);
			//clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadOfertas() {
		this.listOferta = ofertON.getOfertaAcademicas();
	}

}
