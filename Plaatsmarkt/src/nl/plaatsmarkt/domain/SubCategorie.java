package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class SubCategorie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String naam;
	private String omschrijving;
	private ArrayList<Veiling> alleVeilingen;
		
	/* Getters en Setters */
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
	public ArrayList<Veiling> alleVeilingen() {
		return alleVeilingen;
	}
	public void setalleSubCategoriën(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}

}
