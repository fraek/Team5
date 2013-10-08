package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class EditCategorie extends ActionSupport {
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private static final long serialVersionUID = 1L;
	private String naam;
	private String omschrijving;
	private int id;
	private Categorie categorie;
	
	
	public String execute() throws Exception {		
		categorie = new Categorie(naam, omschrijving, id);
		
		dao.update(categorie);
		
		return SUCCESS;
	}
	
	
	
	public void validate(){
		//Categorie aanmaken zodat bij een fail je de ingevulde gegevens ziet
		categorie = new Categorie(naam, omschrijving, id);
		
		if (naam == null || naam.trim().equals("")){
			addFieldError("naam","Een naam is vereist");
		}
		if (omschrijving == null || omschrijving.trim().equals("")){
			addFieldError("omschrijving","Een omschrijving is vereist");
		}
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
