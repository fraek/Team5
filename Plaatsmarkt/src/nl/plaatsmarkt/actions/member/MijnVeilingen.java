package nl.plaatsmarkt.actions.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MijnVeilingen extends ActionSupport implements SessionAware{
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private static final long serialVersionUID = 1L;
	private List<Veiling> alleVeilingen, alleVeilingenEigenaar;
	private int id;
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private Gebruiker SessionGebruiker;

	public String execute() throws Exception {
		alleVeilingenEigenaar = new ArrayList<Veiling>();
		
		setAlleVeilingen(vdao.read());
<<<<<<< HEAD
=======
		//Wordt gebruikt bij MijnVeilingen
>>>>>>> f090ba0e490af2589616d1f5b6b95e41809e209c
		SessionGebruiker = (Gebruiker)session.get("gebruiker");		
		
		for(Veiling c:alleVeilingen){
			if(c.getDeAanbieder().getID() == (SessionGebruiker.getID())){
				alleVeilingenEigenaar.add(c);
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

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = (SessionMap) session;
	}

	public Gebruiker getSessionGebruiker() {
		return SessionGebruiker;
	}

	public void setSessionGebruiker(Gebruiker sessionGebruiker) {
		SessionGebruiker = sessionGebruiker;
	}
}
