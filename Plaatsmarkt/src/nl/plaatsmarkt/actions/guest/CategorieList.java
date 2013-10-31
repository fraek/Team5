package nl.plaatsmarkt.actions.guest;

import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class CategorieList extends ActionSupport{
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private static final long serialVersionUID = 1L;
	private List<Categorie> alleCategorieen;

	public String execute() throws Exception {
		setAlleCategorieen(dao.read());
		return SUCCESS;
	}


	public List<Categorie> getAlleCategorieen() {
		return alleCategorieen;
	}

	public void setAlleCategorieen(List<Categorie> alleCategorieen) {
		this.alleCategorieen = alleCategorieen;
	}
}
