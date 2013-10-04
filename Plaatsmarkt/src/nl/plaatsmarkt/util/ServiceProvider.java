package nl.plaatsmarkt.util;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;


public class ServiceProvider {
	private static DatabaseDAO DatabaseDAO = new DatabaseDAO();
	private static IDAO<Gebruiker> GebruikerDAO = new GebruikerDAO();
	private static IDAO<Categorie> CategorieDAO = new CategorieDAO();
	private static IDAO<SubCategorie> SubCategorieDAO = new SubCategorieDAO();

	public static IDAO<Gebruiker> getGebruikerDAO() {
		return GebruikerDAO;
	}
	public static IDAO<Categorie> getCategorieDAO() {
		return CategorieDAO;
	}
	public static IDAO<SubCategorie> getSubCategorieDAO() {
		return SubCategorieDAO;
	}
	public static DatabaseDAO getDatabaseDAO() {
		return DatabaseDAO;
	}
}
