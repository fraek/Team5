package nl.plaatsmarkt.actions.members;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.GebruikerAware;

import com.opensymphony.xwork2.ActionSupport;

public class MyAccountEdit extends ActionSupport implements GebruikerAware{
	private static final long serialVersionUID = 1L;
	private Gebruiker gebruiker;
	@Override
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;		
	}
	
	public Gebruiker getGebruiker(){
		return gebruiker;
	}

}