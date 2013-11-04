package nl.plaatsmarkt.actions.guest;

import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class SubCategorieList extends ActionSupport {
	private IDAO<SubCategorie> dao = ServiceProvider.getSubCategorieDAO();
	private IDAO<Categorie> Cdao = ServiceProvider.getCategorieDAO();
	private static final long serialVersionUID = 1L;
	private List<SubCategorie> alleSubCategorieen, alleSubCategorieenByID;
	private int id;
	private String locatie;

	public String execute() throws Exception {
		alleSubCategorieenByID = new ArrayList<SubCategorie>();
		setAlleSubCategorieen(dao.read());
		
		Categorie cat = (Categorie) Cdao.getObject(id);
		locatie = cat.getNaam();
		
		for(SubCategorie s:alleSubCategorieen){
			if(s.getCategorie().getID() == id){
				alleSubCategorieenByID.add(s);
			}
		}
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

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
}
