package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<SubCategorie> alleSubCategoriŽn;
	private String naam;
	private String omschrijving;
		
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
	public ArrayList<SubCategorie> alleSubCategoriŽn() {
		return alleSubCategoriŽn;
	}
	public void setalleSubCategoriŽn(ArrayList<SubCategorie> alleSubCategoriŽn) {
		this.alleSubCategoriŽn = alleSubCategoriŽn;
	}

}
