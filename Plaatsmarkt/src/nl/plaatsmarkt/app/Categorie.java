package nl.plaatsmarkt.app;

import java.io.Serializable;
import java.util.ArrayList;

public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String naam;
	private String omschrijving;
	
	
	/* Getters en Setters */
	private ArrayList<Voorwerp> alleVoorwerpen;
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public ArrayList<Voorwerp> getAlleVoorwerpen() {
		return alleVoorwerpen;
	}
	public void setAlleVoorwerpen(ArrayList<Voorwerp> alleVoorwerpen) {
		this.alleVoorwerpen = alleVoorwerpen;
	}

}