package nl.plaatsmarkt.actions.guest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.DateConverter;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class DeVeiling extends ActionSupport implements SessionAware{
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private IDAO<Bod> bdao = ServiceProvider.getBodDAO();
	private static final long serialVersionUID = 1L;
	private int id;
	private Veiling deVeiling;
	private boolean afgelopen, eigenaar;
	private List<Bod> alleBiedingen, alleBiedingenByID;
	private DateConverter dc = new DateConverter();
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private Gebruiker SessionGebruiker, gebruiker;
	private IDAO<Gebruiker> gebruikerdao = ServiceProvider.getGebruikerDAO();

	
	public String execute() throws Exception {
		SessionGebruiker = (Gebruiker)session.get("gebruiker");
		setGebruiker((Gebruiker)gebruikerdao.getObject(SessionGebruiker.getID()));
		
		alleBiedingen = new ArrayList<Bod>();
		alleBiedingenByID = new ArrayList<Bod>();
		
		setDeVeiling((Veiling) vdao.getObject(id));
		//setAlleVeilingen(vdao.read());
		
		setAlleBiedingen(bdao.read());
		for(Bod b:alleBiedingen) {
			if(b.getDeVeiling().getID() == deVeiling.getID()) {
				if(b.getBedrag() > 0) alleBiedingenByID.add(b);
			}
		}
		if(deVeiling.getID() == gebruiker.getID()){
			eigenaar = true;
		}else eigenaar = false;
		afgelopen = dc.datePassed(deVeiling.getVerloopDatum());
		//Sorteren
		Collections.sort(alleBiedingenByID, new Comparator<Bod>() {
		    @Override
		    public int compare(Bod c1, Bod c2) {
		        return new Double(c2.getBedrag()).compareTo(new Double(c1.getBedrag()));
		    }
		});
		
		deVeiling.setAlleBiedingen((ArrayList<Bod>) alleBiedingenByID);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}

	public Veiling getDeVeiling() {
		return deVeiling;
	}

	public void setDeVeiling(Veiling deVeiling) {
		this.deVeiling = deVeiling;
	}

	public List<Bod> getAlleBiedingen() {
		return alleBiedingen;
	}

	public void setAlleBiedingen(List<Bod> list) {
		this.alleBiedingen = list;
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
	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
}
