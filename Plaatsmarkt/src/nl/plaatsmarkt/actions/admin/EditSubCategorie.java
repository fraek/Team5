package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class EditSubCategorie extends ActionSupport {
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private IDAO<SubCategorie> subdao = ServiceProvider.getSubCategorieDAO();
	private static final long serialVersionUID = 1L;
	private String naam;
	private String omschrijving;
	private String categorie;
	private int id;
	private Categorie categorieObject;
	private SubCategorie subcategorie;
	
	
	public String execute() throws Exception {	
		int temp = Integer.parseInt(categorie);
		categorieObject = (Categorie) dao.getObject(temp);
		System.out.println(temp);
		System.out.println(categorie);
		//subcategorie = new SubCategorie(naam, omschrijving, categorieo, temp);
		
		//subdao.update(subcategorie);
		
		return SUCCESS;
	}
	
	public void validate(){
		//Categorie aanmaken zodat bij een fail je de ingevulde gegevens ziet
		//categorieObject = new Categorie(naam, omschrijving, subcategorie.getID());
		//subcategorie = new SubCategorie(categorieObject);
		
		if (naam == null || naam.trim().equals("")){
			addFieldError("naam","Een naam is vereist");
		}
		if (omschrijving == null || omschrijving.trim().equals("")){
			addFieldError("omschrijving","Een omschrijving is vereist");
		}
		if (categorie == null || categorie.equals("") || categorie.equals("Selecteer Categorie")){
			addFieldError("categorie","Een categorie is vereist");
		}
	}
	
	public SubCategorie getSubcategorie() {
		return subcategorie;
	}

	public void setSubcategorie(SubCategorie subcategorie) {
		this.subcategorie = subcategorie;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
