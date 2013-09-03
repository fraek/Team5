package nl.team5.app;

import java.io.Serializable;

public class Lid extends Gebruiker implements Serializable{

	private static final long serialVersionUID = 1L;

	public Lid(String voornaam, String tussenvoegsel, String achternaam,
			String gebruikersnaam, String email, String wachtwoord,
			String adres, String postcode, String woonplaats, int huisnummer,
			long telefoonnummer) {
		super(voornaam, tussenvoegsel, achternaam, gebruikersnaam, email, wachtwoord,
				adres, postcode, woonplaats, huisnummer, telefoonnummer);
	}
	
	//Een test comment voor de branch

}
