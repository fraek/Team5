package nl.plaatsmarkt.actions.admin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class SubCategorieList extends ActionSupport {
	private IDAO<SubCategorie> dao = ServiceProvider.getSubCategorieDAO();
	private static final long serialVersionUID = 1L;
	private List<SubCategorie> alleSubCategorieen;

	public String execute() throws Exception {
		setAlleSubCategorieen(dao.read());

		Collections.sort(alleSubCategorieen, new CustomComparator());
		return SUCCESS;
	}

	public List<SubCategorie> getAlleSubCategorieen() {
		return alleSubCategorieen;
	}

	public void setAlleSubCategorieen(List<SubCategorie> alleSubCategorieen) {
		this.alleSubCategorieen = alleSubCategorieen;
	}
	
	public class CustomComparator implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
            SubCategorie c1 = (SubCategorie) o1;
            SubCategorie c2 = (SubCategorie) o2;
            return c1.getCategorie().getNaam().compareToIgnoreCase(c2.getCategorie().getNaam());
        }
	}
}
