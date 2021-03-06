package nl.plaatsmarkt.actions.guest;

import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class VeilingList extends ActionSupport{
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private IDAO<SubCategorie> scdao = ServiceProvider.getSubCategorieDAO();
	private static final long serialVersionUID = 1L;
	private List<Veiling> alleVeilingen, alleVeilingenByID, alleVeilingenEigenaar;
	private int id;
	private Gebruiker SessionGebruiker;
	private String locatie;

	public String execute() throws Exception {
		alleVeilingenByID = new ArrayList<Veiling>();
		alleVeilingenEigenaar = new ArrayList<Veiling>();
		
		setAlleVeilingen(vdao.read());
		
		SubCategorie sc = (SubCategorie) scdao.getObject(id);
		locatie = sc.getCategorie().getNaam() + "  |  " + sc.getNaam();
		
		for(Veiling v:alleVeilingen){
			if(v.getDeSubCategorie().getID() == id){
				alleVeilingenByID.add(v);
			}
		}
		return SUCCESS;
	}

	public List<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}

	public void setAlleVeilingen(List<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}

	public List<Veiling> getAlleVeilingenByID() {
		return alleVeilingenByID;
	}

	public void setAlleVeilingenByID(List<Veiling> alleVeilingenByID) {
		this.alleVeilingenByID = alleVeilingenByID;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}
	
	public List<Veiling> getAlleVeilingenEigenaar() {
		return alleVeilingenEigenaar;
	}

	public void setAlleVeilingenEigenaar(List<Veiling> alleVeilingenEigenaar) {
		this.alleVeilingenEigenaar = alleVeilingenEigenaar;
	}

	public Gebruiker getSessionGebruiker() {
		return SessionGebruiker;
	}

	public void setSessionGebruiker(Gebruiker sessionGebruiker) {
		SessionGebruiker = sessionGebruiker;
	}

	public String getLocatie() {
		return locatie;
	}

	public void getLocatie(String locatie) {
		this.locatie = locatie;
	}
}
