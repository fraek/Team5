package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.Date;

public class Beheerder extends Gebruiker implements Serializable{
	
	public Beheerder(String voornaam, String tussenvoegsel, String achternaam,
			String gebruikersnaam, String email, String wachtwoord,
			String adres, String postcode, String woonplaats,
			Date geboortedatum, int huisnummer, long telefoonnummer) {
		super(voornaam, tussenvoegsel, achternaam, gebruikersnaam, email, wachtwoord,
				adres, postcode, woonplaats, geboortedatum, huisnummer, telefoonnummer);
	}

	private static final long serialVersionUID = 1L;

	}
