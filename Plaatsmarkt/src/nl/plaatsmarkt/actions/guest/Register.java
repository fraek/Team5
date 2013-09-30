package nl.plaatsmarkt.actions.guest;

import java.util.Date;

import nl.plaatsmarkt.domain.Lid;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private IDAO<?> dao = ServiceProvider.getLidDAO();
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
	private Date geboorteDate;
	private int huisnummer;
	private long telefoonnummer;	//Een int is niet lang genoeg voor een tel.nummer
	private String geslaagd;
	private Lid lid;
	
	/*
	 * Controle of persoon 16 jaar is of ouder
	 * Controle op beide wachtwoorden valid
	 * Controle op valid email
	*/

	@Override
	public String execute() throws Exception {
		lid = new Lid(	voornaam, tussenvoegsel, achternaam, gebruikersnaam, 
						email1, wachtwoord1, adres, postcode, woonplaats, geboorteDate, 
						huisnummer, telefoonnummer);
		dao.create(lid);
		
		setGeslaagd("U bent succesvol geregisteerd met "+ email1);
		
		return SUCCESS;
	}
	
	public void validate(){
		if (voornaam == null || voornaam.trim().equals("")){
			addFieldError("input","Een voornaam is vereist");
		}
		if (achternaam == null || achternaam.trim().equals("")){
			addFieldError("input","Een achternaam is vereist");
		}
		if (gebruikersnaam == null || gebruikersnaam.trim().equals("")){
			addFieldError("input","Een gebruikersnaam is vereist");
		}
		if (email1 == null || email1.trim().equals("")){
			addFieldError("input","Een e-mail adres is vereist");
		}
		if (!email1.equalsIgnoreCase(email2)){
			addFieldError("input","De e-mail adressen komen niet overeen: "  + email1 + email2);
		}
		//else if (2>3){
			//addFieldError("email","Er moet een geldig email adres worden ingevoerd");
		//}
		if (wachtwoord1 == null || wachtwoord1.trim().equals("")){
			addFieldError("input","Een wachtwoord is vereist");
		}
		if (wachtwoord2 == null || wachtwoord2.trim().equals("")){
			addFieldError("input","Een wachtwoord is vereist");
		}
		if (!wachtwoord1.equalsIgnoreCase(wachtwoord2)){
			addFieldError("input","De wachtwoorden komen niet overeen");
		}
		if (geboortedatum == null || geboortedatum.trim().equals("")){
			addFieldError("input","Een geboortedatum is vereist");
		}
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

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	public long getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(long telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
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

	public Date getGeboorteDate() {
		return geboorteDate;
	}

	public void setGeboorteDate(Date geboorteDate) {
		this.geboorteDate = geboorteDate;
	}

	public String getGeslaagd() {
		return geslaagd;
	}

	public void setGeslaagd(String geslaagd) {
		this.geslaagd = geslaagd;
	}

}