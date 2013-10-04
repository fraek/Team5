package nl.plaatsmarkt.actions.members;

import java.util.Date;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.GebruikerRol;
import nl.plaatsmarkt.util.GebruikerAware;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;
import nl.plaatsmarkt.util.Validate;

import com.opensymphony.xwork2.ActionSupport;

public class MyAccountEdit extends ActionSupport implements GebruikerAware{
	private static final long serialVersionUID = 1L;
	private IDAO<?> dao = ServiceProvider.getGebruikerDAO();
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String gebruikersnaam;
	private String email1, email2;
	private String wachtwoord1, wachtwoord2;
	private String adres;
	private String postcode;
	private String woonplaats;
	private String geboortedatum; //Om op te halen
	private String rol; //Om op te halen
	private Date geboorteDate;
	private int id;
	private long telefoonnummer;	//Een int is niet lang genoeg voor een tel.nummer
	private Gebruiker gebruiker;
	private GebruikerRol ENUMRol;
	
	/*
	 * Controle of persoon 16 jaar is of ouder
	 * Controle op beide wachtwoorden valid
	 * Controle op valid email
	 */

	@Override
	public String execute() throws Exception {
		if(rol.equalsIgnoreCase("Member")){
			ENUMRol = GebruikerRol.Member;
		}else if(rol.equalsIgnoreCase("Admin")){
			ENUMRol = GebruikerRol.Admin;
		}
		
		gebruiker = new Gebruiker(id, voornaam, tussenvoegsel, achternaam, gebruikersnaam, email1, 
				wachtwoord1, adres, postcode, woonplaats, geboorteDate, telefoonnummer, ENUMRol);
		
		dao.update(gebruiker);

		return SUCCESS;
	}
	
	public void validate(){
		if (voornaam == null || voornaam.trim().equals("")){
			addFieldError("voornaam","Een voornaam is vereist");
		}
		if (achternaam == null || achternaam.trim().equals("")){
			addFieldError("achternaam","Een achternaam is vereist");
		}
		if (gebruikersnaam == null || gebruikersnaam.trim().equals("")){
			addFieldError("gebruikersnaam","Een gebruikersnaam is vereist");
		}
		if (geboortedatum == null || geboortedatum.trim().equals("")){
			addFieldError("geboortedatum","Een geboortedatum is vereist");
		}
		//Kijken of er een wachtwoord is ingevuld
		if (wachtwoord1 != null || !wachtwoord1.trim().equals("") || 
			wachtwoord2 != null || !wachtwoord2.trim().equals("")){
			//Oke er met een wachtwoord worden veranderd!
			if (wachtwoord1 != null && !wachtwoord1.equals(wachtwoord2)){
				addFieldError("wachtwoord1","De wachtwoorden komen niet overeen");
			}
		}		
		//Kijken of er een email is ingevuld
		if (!email2.trim().equals("")){
			//Er moet een email worden veranderd!
			if (!email1.equalsIgnoreCase(email2)){
				addFieldError("email1","De e-mail adressen komen niet overeen");
			}
			Validate validate = new Validate();
			if(!validate.mail(email1)){
				addFieldError("email1","Het ingevoerde e-mail adres is ongeldig");
			}
		}
	}
	
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;		
	}
	
	public Gebruiker getGebruiker(){
		return gebruiker;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getWachtwoord1() {
		return wachtwoord1;
	}

	public void setWachtwoord1(String wachtwoord1) {
		this.wachtwoord1 = wachtwoord1;
	}

	public String getWachtwoord2() {
		return wachtwoord2;
	}

	public void setWachtwoord2(String wachtwoord2) {
		this.wachtwoord2 = wachtwoord2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public Date getGeboorteDate() {
		return geboorteDate;
	}

	public void setGeboorteDate(Date geboorteDate) {
		this.geboorteDate = geboorteDate;
	}

	public long getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(long telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}