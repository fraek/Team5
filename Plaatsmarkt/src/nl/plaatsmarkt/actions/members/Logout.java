package nl.plaatsmarkt.actions.members;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.GebruikerAware;

public class Logout extends ActionSupport implements GebruikerAware, SessionAware{
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private static final long serialVersionUID = 1L;
	private Gebruiker gebruiker;

	
	public String execute(){
		session.invalidate();
		
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


}
