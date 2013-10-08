package nl.plaatsmarkt.actions.admin;

import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class subcategorieDetails extends ActionSupport {
	private int id;
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private IDAO<SubCategorie> subdao = ServiceProvider.getSubCategorieDAO();
	private static final long serialVersionUID = 1L;
	private Categorie categorie;
	private SubCategorie subcategorie;
	private List<SubCategorie> alleSubCategorieen;

	public String execute() throws Exception {
		setAlleSubCategorieen(subdao.read());
		subcategorie = (SubCategorie) subdao.getObject(id);
		categorie = (Categorie) dao.getObject(subcategorie.getFK_ID());
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public SubCategorie getSubcategorie() {
		return subcategorie;
	}

	public void setSubcategorie(SubCategorie subcategorie) {
		this.subcategorie = subcategorie;
	}

	public List<SubCategorie> getAlleSubCategorieen() {
		return alleSubCategorieen;
	}

	public void setAlleSubCategorieen(List<SubCategorie> alleSubCategorieen) {
		this.alleSubCategorieen = alleSubCategorieen;
	}
}
