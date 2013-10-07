package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class AddCategorie extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private IDAO<?> dao = ServiceProvider.getCategorieDAO();
	private String titel;
	private String omschrijving;
	private String geslaagd;
	private Categorie categorie;

	/*
	 * Controle of naam niet leeg is
	 * Controle of omschrijving niet leeg is
	 */

	@Override
	public String execute() throws Exception {
		categorie = new Categorie(titel, omschrijving);
		dao.create(categorie);

		setGeslaagd("U heeft succesvol de categorie "+ titel + " aangemaakt");

		return SUCCESS;
	}

	@Override
	public void validate(){
		//check if empty
		if (titel == null || titel.trim().equals("")){
			addFieldError("titel","Een titel is vereist");
		}
		if (omschrijving == null || omschrijving.trim().equals("")){
			addFieldError("omschrijving","Een omschrijving is vereist");
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
