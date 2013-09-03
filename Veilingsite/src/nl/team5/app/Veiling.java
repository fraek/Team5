package nl.team5.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Veiling implements Serializable{
	private Gebruiker deGebruiker;	//Degene die de veiling aanmaakt
	private Voorwerp hetVoorwerp;
	private ArrayList<Bod> alleBiedingen;
	private String titel;
	private String beschrijving;
	private Date aanmaakDatum;
	private Date verloopDatum;
}
