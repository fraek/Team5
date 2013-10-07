package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.Date;

public class Gebruiker implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ID;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String gebruikersnaam;
	private String email;
	private String wachtwoord;
	private String adres;
	private String postcode;
	private String woonplaats;
	private Date geboortedatum;
	private GebruikerRol gebruikerRol;
	private long telefoonnummer;	//Een int is niet lang genoeg voor een tel.nummer
	
	
	/* Constructor */
	public Gebruiker(String voornaam, String tussenvoegsel, String achternaam, String gebruikersnaam,
			String email, String wachtwoord, String adres, String postcode, String woonplaats,
			Date geboortedatum, long telefoonnummer){
		
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gebruikersnaam = gebruikersnaam;
		this.email = email;
		this.wachtwoord = wachtwoord;
		this.adres = adres;
		this.postcode = postcode;
		this.woonplaats = woonplaats;
		this.geboortedatum = geboortedatum;
		this.telefoonnummer = telefoonnummer;
		this.gebruikerRol = GebruikerRol.Member;		//Standaard wordt er een member aangemaakt
	}
	
	public Gebruiker(int ID, String voornaam, String tussenvoegsel, String achternaam, String gebruikersnaam,
			String email, String wachtwoord, String adres, String postcode, String woonplaats,
			Date geboortedatum, long telefoonnummer, GebruikerRol rol){
		
		this.ID = ID;
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gebruikersnaam = gebruikersnaam;
		this.email = email;
		this.wachtwoord = wachtwoord;
		this.adres = adres;
		this.postcode = postcode;
		this.woonplaats = woonplaats;
		this.geboortedatum = geboortedatum;
		this.telefoonnummer = telefoonnummer;
		this.gebruikerRol = rol;
	}
	
	public String toString()
    {
		if(!tussenvoegsel.equals("") && !tussenvoegsel.equals(null)){
        return "Voornaam: " + voornaam + " Tussenvoegsel: " + tussenvoegsel + " Achternaam: " + achternaam +
        		" Gebruikersnaam: " + gebruikersnaam + " E-mail: " + email + " Wachtwoord: " + wachtwoord + 
        		" Adres: " + adres + " Postcode: " + postcode + " Woonplaats: " + woonplaats
        		+ " Telefoonnummer: " + telefoonnummer;
		}else{
		return "Voornaam: " + voornaam + " Achternaam: " + achternaam +
        		" Gebruikersnaam: " + gebruikersnaam + " E-mail: " + email + " Wachtwoord: " + wachtwoord + 
        		" Adres: " + adres + " Postcode: " + postcode + " Woonplaats: " + woonplaats + 
        		" Telefoonnummer: " + telefoonnummer;	
		}
    }

	/* Getters en Setters */
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public long getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(long telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public Date getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public GebruikerRol getGebruikerRol() {
		return gebruikerRol;
	}

	public void setGebruikerRol(GebruikerRol gebruikerRol) {
		this.gebruikerRol = gebruikerRol;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
