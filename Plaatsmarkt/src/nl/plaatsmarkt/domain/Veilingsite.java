package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Veilingsite implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String naam;
	private ArrayList<Gebruiker> alleGebruikers;
	private ArrayList<Categorie> alleCategorie�n;
	private ArrayList<Veiling> alleVeilingen;
		
	/* Constructor */
	public Veilingsite(String naam){
		this.naam = naam;
		alleGebruikers = new ArrayList<Gebruiker>();
		alleCategorie�n = new ArrayList<Categorie>();
		alleVeilingen = new ArrayList<Veiling>();
	}
		
	/* Getters en Setters */
	public ArrayList<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}
	public void setAlleGebruikers(ArrayList<Gebruiker> alleGebruikers) {
		this.alleGebruikers = alleGebruikers;
	}
	public ArrayList<Categorie> getAlleCategorie�n() {
		return alleCategorie�n;
	}
	public void setAlleCategorie�n(ArrayList<Categorie> alleCategorie�n) {
		this.alleCategorie�n = alleCategorie�n;
	}
	public ArrayList<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}
	public void setAlleVeilingen(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void addGebruiker(){
		
	}
}
