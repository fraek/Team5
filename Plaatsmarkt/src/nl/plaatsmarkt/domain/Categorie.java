package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<SubCategorie> alleSubCategoriën;
	private String naam;
	private String omschrijving;
	private int ID;
	
	/* Constructors*/
	public Categorie(ArrayList<SubCategorie> alleSubCategoriën, String naam,
			String omschrijving, int iD) {
		this.alleSubCategoriën = alleSubCategoriën;
		this.naam = naam;
		this.omschrijving = omschrijving;
		ID = iD;
	}
	
	public Categorie(ArrayList<SubCategorie> alleSubCategoriën, String naam,
			String omschrijving) {
		this.alleSubCategoriën = alleSubCategoriën;
		this.naam = naam;
		this.omschrijving = omschrijving;
	}
	
	public Categorie(String naam,
			String omschrijving, int iD) {
		this.naam = naam;
		this.omschrijving = omschrijving;
		ID = iD;
	}
	
	public Categorie( String naam,
			String omschrijving) {
		this.naam = naam;
		this.omschrijving = omschrijving;
	}
		
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
	public ArrayList<SubCategorie> alleSubCategoriën() {
		return alleSubCategoriën;
	}
	public void setalleSubCategoriën(ArrayList<SubCategorie> alleSubCategoriën) {
		this.alleSubCategoriën = alleSubCategoriën;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}