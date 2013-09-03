package nl.team5.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Veiling implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Gebruiker deAanbieder;
	private Voorwerp hetVoorwerp;
	private ArrayList<Bod> alleBiedingen;
	private String titel;
	private String beschrijving;
	private Date aanmaakDatum;
	private Date verloopDatum;
	
	
	/* Getters en Setters */
	public Gebruiker getDeAanbieder() {
		return deAanbieder;
	}
	public void setDeAanbieder(Gebruiker deAanbieder) {
		this.deAanbieder = deAanbieder;
	}
	public Voorwerp getHetVoorwerp() {
		return hetVoorwerp;
	}
	public void setHetVoorwerp(Voorwerp hetVoorwerp) {
		this.hetVoorwerp = hetVoorwerp;
	}
	public ArrayList<Bod> getAlleBiedingen() {
		return alleBiedingen;
	}
	public void setAlleBiedingen(ArrayList<Bod> alleBiedingen) {
		this.alleBiedingen = alleBiedingen;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public Date getAanmaakDatum() {
		return aanmaakDatum;
	}
	public void setAanmaakDatum(Date aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
	public Date getVerloopDatum() {
		return verloopDatum;
	}
	public void setVerloopDatum(Date verloopDatum) {
		this.verloopDatum = verloopDatum;
	}
}
