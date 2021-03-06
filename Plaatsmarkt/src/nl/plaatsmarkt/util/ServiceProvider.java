package nl.plaatsmarkt.util;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.domain.Veiling;


public class ServiceProvider {
	private static DatabaseDAO DatabaseDAO = new DatabaseDAO();
	private static IDAO<Gebruiker> GebruikerDAO = new GebruikerDAO();
	private static IDAO<Categorie> CategorieDAO = new CategorieDAO();
	private static IDAO<SubCategorie> SubCategorieDAO = new SubCategorieDAO();
	private static IDAO<Veiling> VeilingDAO = new VeilingDAO();
	private static IDAO<Bod> BodDAO = new BodDAO();

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
	public static IDAO<Veiling> getVeilingDAO() {
		return VeilingDAO;
	}
	public static IDAO<Bod> getBodDAO() {
		return BodDAO;
	}
}
