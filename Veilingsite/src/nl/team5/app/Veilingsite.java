package nl.team5.app;

import java.io.Serializable;
import java.util.ArrayList;

public class Veilingsite implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Gebruiker> alleGebruikers;
	private ArrayList<Categorie> alleCategorieŽn;
	private ArrayList<Veiling> alleVeilingen;
		
	
	/* Getters en Setters */
	public ArrayList<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}
	public void setAlleGebruikers(ArrayList<Gebruiker> alleGebruikers) {
		this.alleGebruikers = alleGebruikers;
	}
	public ArrayList<Categorie> getAlleCategorieŽn() {
		return alleCategorieŽn;
	}
	public void setAlleCategorieŽn(ArrayList<Categorie> alleCategorieŽn) {
		this.alleCategorieŽn = alleCategorieŽn;
	}
	public ArrayList<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}
	public void setAlleVeilingen(ArrayList<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}
}
