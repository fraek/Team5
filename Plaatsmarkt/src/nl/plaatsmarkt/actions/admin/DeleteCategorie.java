package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCategorie extends ActionSupport {
	private IDAO<Categorie> dao = ServiceProvider.getCategorieDAO();
	private static final long serialVersionUID = 1L;
	private int id;

	public String execute() throws Exception {
		dao.delete(id);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
