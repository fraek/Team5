package nl.plaatsmarkt.actions.admin;

import java.util.Collections;
import java.util.Comparator;
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
		Collections.sort(alleCategorieen, new CustomComparator());
		return SUCCESS;
	}


	public List<Categorie> getAlleCategorieen() {
		return alleCategorieen;
	}

	public void setAlleCategorieen(List<Categorie> alleCategorieen) {
		this.alleCategorieen = alleCategorieen;
	}
	
	public class CustomComparator implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
            Categorie c1 = (Categorie) o1;
            Categorie c2 = (Categorie) o2;
            return c1.getNaam().compareToIgnoreCase(c2.getNaam());
        }
	}
}
