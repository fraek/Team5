package nl.plaatsmarkt.actions.member;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.GebruikerAware;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;
import nl.plaatsmarkt.util.Validator;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddBod extends ActionSupport implements GebruikerAware, SessionAware{

	private static final long serialVersionUID = 1L;
	private IDAO<Veiling> veilingdao = ServiceProvider.getVeilingDAO();
	private IDAO<Gebruiker> gebruikerdao = ServiceProvider.getGebruikerDAO();
	private IDAO<Bod> boddao = ServiceProvider.getBodDAO();
	private List<Bod> alleBiedingen;

	//private Gebruiker deBieder;
	private double amount;
	private String bedrag;
	private Date datum;
	private Bod bod;
	private int veilingID;
	private Veiling deVeiling;
	//session user
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private Gebruiker SessionGebruiker, gebruiker;
	
	private Validator validator = new Validator();

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
		bod = new Bod(amount, gebruiker, datum, deVeiling);
		System.out.println(bod.getBedrag());
		System.out.println(bod.getDeBieder().getVoornaam());
		System.out.println(bod.getDatum());
		System.out.println(bod.getDeVeiling().getID());
		
		boddao.create(bod);
		
		return SUCCESS;
	}
	
	public void validate(){
		try { alleBiedingen = boddao.read();
		} catch (SQLException e) { e.printStackTrace(); }
		double d = 0;
		if(validator.bedrag(bedrag)){
			d = Double.parseDouble(bedrag);
		} else addFieldError("bedrag","Incorrect bedrag");
		if(!validator.bod(veilingID, alleBiedingen, d)){
			addFieldError("bedrag","Bedrag is lager dan er al geboden is.");
		}
		
	}

	public int getVeilingID() {
		return veilingID;
	}

	public void setVeilingID(int veilingID) {
		this.veilingID = veilingID;
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
	public String getBedrag() {
		return bedrag;
	}

	public void setBedrag(String bedrag) {
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
