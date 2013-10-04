package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class SubCategorie implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Veiling> alleVeilingen;
	private String naam;
	private String omschrijving;
	private int ID;
	
	/* Constructors*/
	public SubCategorie(ArrayList<Veiling> alleVeilingen, String naam,
			String omschrijving, int iD) {
		this.alleVeilingen = alleVeilingen;
		this.naam = naam;
		this.omschrijving = omschrijving;
		ID = iD;
	}
	
	public SubCategorie(ArrayList<Veiling> alleVeilingen, String naam,
			String omschrijving) {
		this.alleVeilingen = alleVeilingen;
		this.naam = naam;
		this.omschrijving = omschrijving;
	}
	
	public SubCategorie(String naam,
			String omschrijving, int iD) {
		this.naam = naam;
		this.omschrijving = omschrijving;
		ID = iD;
	}
	
	public SubCategorie(String naam,
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
	public ArrayList<Veiling> alleVeilingen() {
		return alleVeilingen;
	}
	public void setalleSubCategoriën(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
