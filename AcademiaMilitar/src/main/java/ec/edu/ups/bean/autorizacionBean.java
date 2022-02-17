package ec.edu.ups.bean;

import java.io.IOException;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class autorizacionBean implements PhaseListener {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		try {
			String paginaActual = event.getFacesContext().getViewRoot().getViewId();
			sesionBean.iniciarSesion(event.getFacesContext());
			
			if (!paginaActual.contains("VentanaIniciarSesion.xhtml") && sesionBean.getEstadoSesion() == false) {				
				FacesContext.getCurrentInstance().getExternalContext().redirect("VentanaIniciarSesion.xhtml?faces-redirect=true");
	
				NavigationHandler nh = event.getFacesContext().getApplication().getNavigationHandler();
				nh.handleNavigation(event.getFacesContext(), null, "VentanaIniciarSesion");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}


}
