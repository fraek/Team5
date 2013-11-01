package nl.plaatsmarkt.actions.member;

import java.util.Date;
import java.util.Map;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.GebruikerAware;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddBod extends ActionSupport implements GebruikerAware, SessionAware{

	private static final long serialVersionUID = 1L;
	private IDAO<Veiling> veilingdao = ServiceProvider.getVeilingDAO();
	private IDAO<Gebruiker> gebruikerdao = ServiceProvider.getGebruikerDAO();
	private IDAO<Bod> boddao = ServiceProvider.getBodDAO();

	//private Gebruiker deBieder;
	private double bedrag;
	private Date datum;
	private Bod bod;
	private int veilingID;
	private Veiling deVeiling;
	//session user
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private Gebruiker SessionGebruiker, gebruiker;

	@Override
	public String execute() throws Exception {
		SessionGebruiker = (Gebruiker)session.get("gebruiker");
		setGebruiker((Gebruiker)gebruikerdao.getObject(SessionGebruiker.getID()));
		//Veiling veiling = new Veiling();
		
		//subcategorie = (SubCategorie) subcatdao.getObject(subcats);
		//System.out.println(subcategorie);
		//System.out.println("subcategorie id: " + subcats + ", naam: ");
		//System.out.println("Gebruiker: " + gebruiker.getGebruikersnaam());
		//System.out.println("Veiling titel: " + titel + ", omschrijving: " + omschrijving);
		
		deVeiling = (Veiling) veilingdao.getObject(veilingID);
		
		datum = new Date();
		bod = new Bod(bedrag, gebruiker, datum, deVeiling);
		
		boddao.create(bod);
		
		return SUCCESS;
	}

	@Override
	public void validate(){
		
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
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
	public double getBedrag() {
		return bedrag;
	}

	public void setBedrag(double bedrag) {
		this.bedrag = bedrag;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Bod getBod() {
		return bod;
	}

	public void setBod(Bod bod) {
		this.bod = bod;
	}
}
