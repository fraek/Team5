package nl.plaatsmarkt.actions.users;

import nl.plaatsmarkt.app.Gebruiker;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterForm extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Gebruiker gebruiker;
	
	/*
	 * Controle of persoon 16 jaar is of ouder
	 * Controle op beide wachtwoorden valid
	 * Controle op valid email
	*/

	@Override
	public String execute() throws Exception {
		
		//call Service class to store gebruiker's state in database
		
		return SUCCESS;
		
	}

	public void validate(){
		if (gebruiker.getVoornaam() == null || gebruiker.getVoornaam().trim().equals("")){
			addFieldError("name","Een voornaam is vereist");
		}
		if (gebruiker.getAchternaam() == null || achternaam.getVoornaam().trim().equals("")){
			addFieldError("name","Een achternaam is vereist");
		}
		if (gebruiker.getVoornaam() == null || gebruiker.getVoornaam().trim().equals("")){
			addFieldError("name","Een voornaam is vereist");
		}
		if (gebruiker.getVoornaam() == null || gebruiker.getVoornaam().trim().equals("")){
			addFieldError("name","Een voornaam is vereist");
		}
		if (gebruiker.getVoornaam() == null || gebruiker.getVoornaam().trim().equals("")){
			addFieldError("name","Een voornaam is vereist");
		}
		if (gebruiker.getVoornaam() == null || gebruiker.getVoornaam().trim().equals("")){
			addFieldError("name","Een voornaam is vereist");
		}
	}
	
	public Gebruiker getGebruiker() {
		
		return gebruiker;
		
	}
	
	public void setPersonBean(Gebruiker nieuweGebruiker) {
		
		gebruiker = nieuweGebruiker;
		
	}

}