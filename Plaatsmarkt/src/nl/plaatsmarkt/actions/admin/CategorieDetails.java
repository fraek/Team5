package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class CategorieDetails extends ActionSupport {
	private int id;
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private static final long serialVersionUID = 1L;
	private Categorie categorie;
	
	public String execute() throws Exception {
		categorie = (Categorie) dao.getObject(id);
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

	@Override
	public String toString() {
		return "CategorieDetails [id=" + id + ", categorie=" + categorie + "]";
	}
	
}
