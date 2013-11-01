package nl.plaatsmarkt.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Bod implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double Bedrag;
	private Gebruiker deBieder;
	private Date datum;
	private Time tijd;
	private int ID;
	private Veiling deVeiling;
	
	/* Constructors*/
	public Bod(double bedrag, Gebruiker deBieder, Date datum, Time tijd, int iD) {
		Bedrag = bedrag;
		this.deBieder = deBieder;
		this.datum = datum;
		this.tijd = tijd;
		ID = iD;
	}
	public Bod(double bedrag, Gebruiker deBieder, Date datum, Time tijd) {
		Bedrag = bedrag;
		this.deBieder = deBieder;
		this.datum = datum;
		this.tijd = tijd;
	}
	
	public Bod(double b, Gebruiker bieder, Date d, Veiling v){
		Bedrag = b;
		this.deBieder = bieder;
		this.datum = d;
		this.setDeVeiling(v);
	}
	
	public Bod(double b, Gebruiker bieder, Date d, Veiling v, int iD){
		Bedrag = b;
		this.deBieder = bieder;
		this.datum = d;
		this.setDeVeiling(v);
		ID = iD;
	}
	
	/* Getters en Setters */
	public double getBedrag() {
		return Bedrag;
	}
	public void setBedrag(double bedrag) {
		Bedrag = bedrag;
	}
	public Gebruiker getDeBieder() {
		return deBieder;
	}
	public void setDeBieder(Gebruiker deBieder) {
		this.deBieder = deBieder;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Time getTijd() {
		return tijd;
	}
	public void setTijd(Time tijd) {
		this.tijd = tijd;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Veiling getDeVeiling() {
		return deVeiling;
	}
	public void setDeVeiling(Veiling deVeiling) {
		this.deVeiling = deVeiling;
	}
}
