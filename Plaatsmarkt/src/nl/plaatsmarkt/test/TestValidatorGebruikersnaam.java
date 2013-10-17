package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorGebruikersnaam {
	//test attributen
	private String gebruikersnaam;
	Validator v = new Validator();

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		gebruikersnaam = "";
	}

	//TESTS VOOR GEBRUIKERSNAAM
	//Testpad ID: 1
	@Test
	public void testGebruikersnaamLeeg() {
		gebruikersnaam="";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testGebruikersnaamOngeldig() {
		gebruikersnaam="@#!";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testGebruikersnaamBevatCijfers() {
		gebruikersnaam="piet12";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 4
	@Test
	public void testGebruikersnaamBevatHoofdletters() {
		gebruikersnaam="Piet12";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 5
	@Test
	public void testGebruikersnaamBevatTeken() {
		gebruikersnaam="Piet_12";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 6
	@Test
	public void testGebruikersnaamTeLang() {
		gebruikersnaam="AbcDefGhiJkl12345";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 7
	@Test
	public void testGebruikersnaamTeKort() {
		gebruikersnaam="Ei";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 8
	@Test
	public void testGebruikersnaamGeldig() {
		gebruikersnaam="Tho-Mas_94";
		boolean result = v.gebruikersnaam(gebruikersnaam);
		assertTrue("failure - should be true", result);
	}
}
