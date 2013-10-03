package nl.plaatsmarkt.util;

import nl.plaatsmarkt.domain.Gebruiker;


public class ServiceProvider {
	private static DatabaseDAO DatabaseDAO = new DatabaseDAO();
	private static IDAO<Gebruiker> GebruikerDAO = new GebruikerDAO();

	public static IDAO<Gebruiker> getLidDAO() {
		return GebruikerDAO;
	}

	public static DatabaseDAO getDatabaseDAO() {
		return DatabaseDAO;
	}
}
