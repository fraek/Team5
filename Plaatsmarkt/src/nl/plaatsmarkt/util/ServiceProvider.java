package nl.plaatsmarkt.util;

import nl.plaatsmarkt.domain.Lid;


public class ServiceProvider {
	private static DatabaseDAO DatabaseDAO = new DatabaseDAO();
	private static IDAO<Lid> LidDAO = new LidDAO();

	public static IDAO<Lid> getLidDAO() {
		return LidDAO;
	}

	public static DatabaseDAO getDatabaseDAO() {
		return DatabaseDAO;
	}
}
