package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Veilingsite implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String naam;
	private ArrayList<Gebruiker> alleGebruikers;
	private ArrayList<Categorie> alleCategorieën;
	private ArrayList<Veiling> alleVeilingen;
		
	/* Constructor */
	public Veilingsite(String naam){
		this.naam = naam;
		alleGebruikers = new ArrayList<Gebruiker>();
		alleCategorieën = new ArrayList<Categorie>();
		alleVeilingen = new ArrayList<Veiling>();
	}
		
	/* Getters en Setters */
	public ArrayList<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}
	public void setAlleGebruikers(ArrayList<Gebruiker> alleGebruikers) {
		this.alleGebruikers = alleGebruikers;
	}
	public ArrayList<Categorie> getAlleCategorieën() {
		return alleCategorieën;
	}
	public void setAlleCategorieën(ArrayList<Categorie> alleCategorieën) {
		this.alleCategorieën = alleCategorieën;
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
