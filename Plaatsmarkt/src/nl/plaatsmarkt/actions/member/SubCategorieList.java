package nl.plaatsmarkt.actions.member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nl.plaatsmarkt.actions.guest.CategorieList.CustomComparator;
import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class SubCategorieList extends ActionSupport {
	private IDAO<SubCategorie> dao = ServiceProvider.getSubCategorieDAO();
	private static final long serialVersionUID = 1L;
	private List<SubCategorie> alleSubCategorieen, alleSubCategorieenByID;
	private int id;

	public String execute() throws Exception {
		alleSubCategorieenByID = new ArrayList<SubCategorie>();
		setAlleSubCategorieen(dao.read());
		
		
		for(SubCategorie s:alleSubCategorieen){
			if(s.getCategorie().getID() == id){
				alleSubCategorieenByID.add(s);
			}
		}
		
		Collections.sort(alleSubCategorieen, new CustomComparator());
		Collections.sort(alleSubCategorieenByID, new CustomComparator());
		return SUCCESS;
	}

	public List<SubCategorie> getAlleSubCategorieenByID() {
		return alleSubCategorieenByID;
	}

	public void setAlleSubCategorieenByID(List<SubCategorie> alleSubCategorieenByID) {
		this.alleSubCategorieenByID = alleSubCategorieenByID;
	}

	public List<SubCategorie> getAlleSubCategorieen() {
		return alleSubCategorieen;
	}

	public void setAlleSubCategorieen(List<SubCategorie> alleSubCategorieen) {
		this.alleSubCategorieen = alleSubCategorieen;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}
	
	public class CustomComparator implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
            SubCategorie sc1 = (SubCategorie) o1;
            SubCategorie sc2 = (SubCategorie) o2;
            return sc1.getNaam().compareToIgnoreCase(sc2.getNaam());
        }
	}
}
