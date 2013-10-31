package nl.plaatsmarkt.actions.guest;

import java.util.Date;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.DateConverter;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;
import nl.plaatsmarkt.util.Validator;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private IDAO<?> dao = ServiceProvider.getGebruikerDAO();
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String gebruikersnaam;
	private String email1, email2;
	private String wachtwoord1;//, wachtwoord2;
	private String adres;
	private String postcode;
	private String woonplaats;
	private String geboortedatum; //Om op te halen
	private Date geboorteDate;
	private int huisnummer;
	private long telefoonnummer;	//Een int is niet lang genoeg voor een tel.nummer
	private String geslaagd;
	private Gebruiker gebruiker;

	/*
	 * Controle of persoon 16 jaar is of ouder
	 * Controle op beide wachtwoorden valid
	 * Controle op valid email
	 */

	@Override
	public String execute() throws Exception {
		DateConverter dc = new DateConverter();
		java.util.Date geboorteDate = dc.stringToDate(geboortedatum);
		//gebruiker = new Gebruiker(voornaam, tussenvoegsel, achternaam, gebruikersnaam, email1, 
		//		wachtwoord1, adres, postcode, woonplaats, geboorteDate, telefoonnummer);
		gebruiker = new Gebruiker(voornaam, tussenvoegsel, achternaam, gebruikersnaam, email1, adres, postcode, woonplaats, geboorteDate, telefoonnummer);
		dao.create(gebruiker);

		setGeslaagd("U bent succesvol geregisteerd met "+ email1);

		return SUCCESS;
	}

	@Override
	public void validate(){
		Validator validator = new Validator();
		
		if		(	(voornaam == null || voornaam.trim().equals("")				)									 
				& 	(achternaam == null || achternaam.trim().equals("")			)					
				& 	(gebruikersnaam == null || gebruikersnaam.trim().equals("")	)
				& 	(email1 == null || email1.trim().equals("")					)						
				& 	(email2 == null || email2.trim().equals("")					)						
				//& 	(wachtwoord1 == null || wachtwoord1.trim().equals("")		)				
				//& 	(wachtwoord2 == null || wachtwoord2.trim().equals("")		)				
				& 	(geboortedatum == null || geboortedatum.trim().equals("")	)	
				)
		{
			addFieldError("voornaam","Velden met * zijn verplicht");
		}else{
			//check if empty
			if (validator.isLeeg(voornaam)){
				addFieldError("voornaam","Een voornaam is vereist");
			}
			if (validator.isLeeg(achternaam)){
				addFieldError("achternaam","Een achternaam is vereist");
			}
			if (validator.isLeeg(gebruikersnaam)){
				addFieldError("gebruikersnaam","Een gebruikersnaam is vereist");
			}
			if (validator.isLeeg(email1)){
				addFieldError("email1","Een e-mail adres is vereist");
			}
			if (validator.isLeeg(email2)){
				addFieldError("email2","Een e-mail adres is vereist");
			}
			if (!email1.equals(email2)){
				addFieldError("email1","De e-mail adressen komen niet overeen");
			}
			/*if (validator.isLeeg(wachtwoord1)){
				addFieldError("wachtwoord1","Een wachtwoord is vereist");
			}
			if (validator.isLeeg(wachtwoord2)){
				addFieldError("wachtwoord2","Een wachtwoord is vereist");
			}
			if (!wachtwoord1.equals(wachtwoord2)){
				addFieldError("wachtwoord1","De wachtwoorden komen niet overeen");
			}*/
			if (validator.isLeeg(geboortedatum)){
				addFieldError("geboortedatum","Een geboortedatum is vereist");
			}
			//validator checks
			if(!validator.gebruikersnaam(gebruikersnaam)){
				addFieldError("gebruikersnaam","Gebruikersnaam is ongeldig");
			}
			if(!validator.mail(email1)){
				addFieldError("email1","Email is ongeldig");
			}
			if(!validator.postcode(postcode)){
				addFieldError("postcode","Postcode is ongeldig");
			}
			if(!validator.datum(geboortedatum)){
				addFieldError("geboortedatum","Geboorte datum is ongeldig");
			}
			/*if(!validator.wachtwoord(wachtwoord1)){
				addFieldError("wachtwoord1", "Wachtwoord is ongeldig");
			}*/
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

	/*public String getWachtwoord2() {
		return wachtwoord2;
	}

	public void setWachtwoord2(String wachtwoord2) {
		this.wachtwoord2 = wachtwoord2;
	}*/

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