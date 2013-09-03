package nl.team5.app;

import java.io.Serializable;

public abstract class Gebruiker implements Serializable{
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String gebruikersnaam;
	private String email;
	private String wachtwoord;
	private String adres;
	private String postcode;
	private String woonplaats;
	private int huisnummer;
	private long telefoonnummer;	//Een int is niet lang genoeg voor een tel.nummer
}
