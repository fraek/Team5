package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteSubCategorie extends ActionSupport {
	private IDAO<SubCategorie> dao = ServiceProvider.getSubCategorieDAO();
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
