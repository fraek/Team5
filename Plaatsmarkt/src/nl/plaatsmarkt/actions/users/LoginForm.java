package nl.plaatsmarkt.actions.users;

import com.opensymphony.xwork2.ActionSupport;

public class LoginForm extends ActionSupport {
	private String gebruikersnaam;
	private String wachtwoord;
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	public void validate(){
		
	}
	public String getGebruikersnaam(){
		return this.gebruikersnaam;
	}
	public void setGebruikersnaam(String gebnaam){
		this.gebruikersnaam = gebnaam;
	}
	public String getWachtwoord(){
		return this.wachtwoord;
	}
	public void setWachtwoord(String wwoord){
		this.wachtwoord = wwoord;
	}
}
