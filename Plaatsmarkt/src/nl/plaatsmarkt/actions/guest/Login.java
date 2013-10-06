package nl.plaatsmarkt.actions.guest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.GebruikerRol;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private IDAO<?> dao = ServiceProvider.getGebruikerDAO();
	@SuppressWarnings("rawtypes")
	private Map session;
	private String gebruikersnaam;
	private String wachtwoord;
	private Gebruiker gebruiker;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if(gebruiker.getGebruikerRol() == GebruikerRol.Member){
			session.put( "gebruiker", gebruiker);
			return "member";
		}if(gebruiker.getGebruikerRol() == GebruikerRol.Admin){
			session.put( "gebruiker", gebruiker);
			return "admin";
		}if(gebruiker.getGebruikerRol() == GebruikerRol.Geblokkeerd){
			return "geblokkeerd";
		}
		return SUCCESS;
	}
	
	public void validate(){
		boolean LoginCheck = true; //Should it do a login check?
		if	((gebruikersnaam == null || gebruikersnaam.trim().equals("")) && 	
				(wachtwoord == null || wachtwoord.trim().equals(""))){
			addFieldError("gebruikersnaam","Voer hieronder uw gegevens in");
		}else{
			if	(gebruikersnaam == null || gebruikersnaam.trim().equals("")){
				addFieldError("gebruikersnaam","Geen gebruikersnaam ingevoerd");
				LoginCheck = false;
			}
			if	(wachtwoord == null || wachtwoord.trim().equals("")){
				addFieldError("gebruikersnaam","Geen wachtwoord ingevoerd");
				LoginCheck = false;
			}
			if (LoginCheck){
				if(!validLogin(gebruikersnaam, wachtwoord)){
					addFieldError("gebruikersnaam","Geen goede login");
				}
			}
		}
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	
	public boolean validLogin(String username, String password){
		boolean b = false;
		
		try {
			//Alle gebruikers ophalen en kijken of wachtwoord en gebruikersnaam overeenkomen
			@SuppressWarnings("unchecked")
			List<Gebruiker> alleGebruikers = (List<Gebruiker>) dao.read();
			for(Gebruiker geb : alleGebruikers){
				if(geb.getWachtwoord().equalsIgnoreCase(password) && geb.getGebruikersnaam().equals(username)){
					b = true;
					setGebruiker(geb);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;		
	}
	
}
