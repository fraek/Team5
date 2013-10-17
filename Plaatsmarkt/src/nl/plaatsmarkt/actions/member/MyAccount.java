package nl.plaatsmarkt.actions.member;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.DateConverter;
import nl.plaatsmarkt.util.GebruikerAware;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class MyAccount extends ActionSupport implements GebruikerAware, SessionAware{
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private IDAO<?> dao = ServiceProvider.getGebruikerDAO();
	private static final long serialVersionUID = 1L;
	private Gebruiker gebruiker, SessionGebruiker;
	private DateConverter dc = new DateConverter();

	public String execute() throws Exception {
		SessionGebruiker = (Gebruiker)session.get("gebruiker");
		setGebruiker((Gebruiker)dao.getObject(SessionGebruiker.getID()));
		return SUCCESS;
	}
	
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;		
	}
	
	public Gebruiker getGebruiker(){
		return gebruiker;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = (SessionMap) session;
	}

	public Gebruiker getSessionGebruiker() {
		return SessionGebruiker;
	}

	public void setSessionGebruiker(Gebruiker sessionGebruiker) {
		SessionGebruiker = sessionGebruiker;
	}
	
	public DateConverter getDc() {
		return dc;
	}


}