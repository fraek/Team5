package nl.plaatsmarkt.actions.member;

import java.util.Date;
import java.util.Map;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.DateConverter;
import nl.plaatsmarkt.util.GebruikerAware;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddVeiling extends ActionSupport implements GebruikerAware, SessionAware{

	private static final long serialVersionUID = 1L;
	private IDAO<SubCategorie> subcatdao = ServiceProvider.getSubCategorieDAO();
	private IDAO<Veiling> veilingdao = ServiceProvider.getVeilingDAO();
	private IDAO<Gebruiker> gebruikerdao = ServiceProvider.getGebruikerDAO();
	private DateConverter dc = new DateConverter();
	
	private String titel;
	private String omschrijving;
	private String verloopDatum;
	private int subcats;
	private SubCategorie subcategorie;
	//session user
	@SuppressWarnings("rawtypes")
	private SessionMap session;
	private Gebruiker SessionGebruiker, gebruiker;

	@Override
	public String execute() throws Exception {
		SessionGebruiker = (Gebruiker)session.get("gebruiker");
		setGebruiker((Gebruiker)gebruikerdao.getObject(SessionGebruiker.getID()));
		
		subcategorie = (SubCategorie) subcatdao.getObject(subcats);
		Date verloopDate = dc.stringToDate(verloopDatum);
		System.out.println(subcategorie.getID());
		System.out.println("subcategorie id: " + subcats + ", naam: ");
		System.out.println("Gebruiker: " + gebruiker.getGebruikersnaam());
		System.out.println("Veiling titel: " + titel + ", omschrijving: " + omschrijving);
		
		Veiling veiling = new Veiling(gebruiker, subcategorie, titel, omschrijving, new Date(), verloopDate);
		veilingdao.create(veiling);
		
		return SUCCESS;
	}

	@Override
	public void validate(){
		
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public int getSubcats() {
		return subcats;
	}

	public void setSubcats(int subcats) {
		this.subcats = subcats;
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

	public SubCategorie getSubcategorie() {
		return subcategorie;
	}

	public void setSubcategorie(SubCategorie subcategorie) {
		this.subcategorie = subcategorie;
	}

	public String getVerloopDatum() {
		return verloopDatum;
	}

	public void setVerloopDatum(String verloopDatum) {
		this.verloopDatum = verloopDatum;
	}
	
	
}
