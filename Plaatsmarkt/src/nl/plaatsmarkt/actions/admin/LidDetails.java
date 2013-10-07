package nl.plaatsmarkt.actions.admin;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.GebruikerRol;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class LidDetails extends ActionSupport{
	private int id;
	private IDAO<Gebruiker> dao = ServiceProvider.getGebruikerDAO();
	private static final long serialVersionUID = 1L;
	private Gebruiker gebruiker;
	private GebruikerRol[] rechtenlijst = GebruikerRol.values();
	
	public String execute() throws Exception {
		gebruiker = (Gebruiker) dao.getObject(id);
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public GebruikerRol[] getRechtenlijst() {
		return rechtenlijst;
	}

	public void setRechtenlijst(GebruikerRol[] rechtenlijst) {
		this.rechtenlijst = rechtenlijst;
	}
}