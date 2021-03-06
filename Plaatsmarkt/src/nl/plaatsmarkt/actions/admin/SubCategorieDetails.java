package nl.plaatsmarkt.actions.admin;

import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class SubCategorieDetails extends ActionSupport {
	private int id;
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private IDAO<SubCategorie> subdao = ServiceProvider.getSubCategorieDAO();
	private static final long serialVersionUID = 1L;
	private Categorie categorie;
	private SubCategorie subcategorie;
	private List<Categorie> alleCategorieen;

	public String execute() throws Exception {
		setAlleCategorieen((List<Categorie>)dao.read());
		//System.out.println(id);
		subcategorie = (SubCategorie) subdao.getObject(id);
		//System.out.println(subcategorie.getNaam());
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

	public List<Categorie> getAlleCategorieen() {
		return alleCategorieen;
	}

	public void setAlleCategorieen(List<Categorie> alleCategorieen) {
		this.alleCategorieen = alleCategorieen;
	}

	@Override
	public String toString() {
		return "SubCategorieDetails [id=" + id + ", categorie=" + categorie
				+ ", subcategorie=" + subcategorie + ", alleCategorieen="
				+ alleCategorieen + "]";
	}
	
}
