package nl.team5.app;

import java.io.Serializable;

public class Voorwerp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String naam;
	private String beschrijving;
	private String status;
	private Categorie categorie; //Discutabel...
	
	
	/* Getters en Setters */
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
