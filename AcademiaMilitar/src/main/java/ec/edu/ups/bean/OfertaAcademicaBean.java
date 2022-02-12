package ec.edu.ups.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.business.MallaCurricularONLocal;
import ec.edu.ups.business.OfertaAcademicaON;
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

	public OfertaAcademica getOferta() {
		return oferta;
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
			//clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar2() {
		System.out.println("Guardando Malla");
		try {
			malla.setOfertaAcademica(buscar());
			mallOn.insertar(this.malla);
			//clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public OfertaAcademica buscar() {
		List<OfertaAcademica> lista = ofertON.getOfertaAcademicas();
		for(int i = 0; i<lista.size(); i++) {
			if(i==lista.size()-1) {
				return lista.get(i);
			}
		}
		return null;
	}

}
