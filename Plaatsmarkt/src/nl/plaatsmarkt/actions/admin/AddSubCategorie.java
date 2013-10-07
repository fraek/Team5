package nl.plaatsmarkt.actions.admin;

import java.sql.SQLException;
import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class AddSubCategorie extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private IDAO<SubCategorie> subdao = ServiceProvider.getSubCategorieDAO();
	private String titel;
	private String omschrijving;
	private String categorieTitel;
	private String geslaagd;
	private Categorie categorie;
	private SubCategorie subcategorie;
	private List<Categorie> alleCategorieen;

	/*
	 * Controle of naam niet leeg is
	 * Controle of omschrijving niet leeg is
	 */

	@Override
	public String execute() throws Exception {
		categorie = (Categorie) dao.getObject(categorieTitel);
		subcategorie = new SubCategorie(titel, omschrijving, categorie);
		subdao.create(subcategorie);

		setGeslaagd("U heeft succesvol de categorie "+ titel + " aangemaakt");

		return SUCCESS;
	}

	@Override
	public void validate(){
		try {
			setAlleCategorieen(dao.read());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//check if empty
		if (titel == null || titel.trim().equals("")){
			addFieldError("titel","Een titel is vereist");
		}
		if (omschrijving == null || omschrijving.trim().equals("")){
			addFieldError("omschrijving","Een omschrijving is vereist");
		}
		if (categorieTitel == null || categorieTitel.equals("") || categorieTitel.equals("Selecteer Categorie")){
			addFieldError("categorieTitel","Een categorie is vereist");
		}
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public List<Categorie> getAlleCategorieen() {
		return alleCategorieen;
	}

	public void setAlleCategorieen(List<Categorie> alleCategorieen) {
		this.alleCategorieen = alleCategorieen;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getGeslaagd() {
		return geslaagd;
	}

	public void setGeslaagd(String geslaagd) {
		this.geslaagd = geslaagd;
	}
}
