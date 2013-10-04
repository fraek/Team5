package nl.plaatsmarkt.actions;

import java.util.Map;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.GebruikerAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Welkom extends ActionSupport implements GebruikerAware{
	private static final long serialVersionUID = 1L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	Gebruiker gebruiker = (Gebruiker) session.get("gebruiker");
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@Override
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	
	public Gebruiker getGebruiker(){
		return gebruiker;
	}

}
