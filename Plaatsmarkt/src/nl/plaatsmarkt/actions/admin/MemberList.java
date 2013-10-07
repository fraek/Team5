package nl.plaatsmarkt.actions.admin;

import java.util.List;

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
		return SUCCESS;
	}


	public List<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}

	public void setAlleGebruikers(List<Gebruiker> alleGebruikers) {
		this.alleGebruikers = alleGebruikers;
	}
}