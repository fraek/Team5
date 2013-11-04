package nl.plaatsmarkt.actions.admin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class MemberList extends ActionSupport{
	private IDAO<Gebruiker> dao = ServiceProvider.getGebruikerDAO();
	private static final long serialVersionUID = 1L;
	private List<Gebruiker> alleGebruikers;

	public String execute() throws Exception {
		setAlleGebruikers(dao.read());
		//Sorteren
		Collections.sort(alleGebruikers, new Comparator<Gebruiker>() {
		    @Override
		    public int compare(Gebruiker g1, Gebruiker g2) {
		        return new Double(g1.getID()).compareTo(new Double(g2.getID()));
		    }
		});
		
		return SUCCESS;
	}


	public List<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}

	public void setAlleGebruikers(List<Gebruiker> alleGebruikers) {
		this.alleGebruikers = alleGebruikers;
	}
	
	
}