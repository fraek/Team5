package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorBeschrijving {
	//test attributen
	private String beschrijving;
	Validator v = new Validator();

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		beschrijving = "";
	}

	//TESTS VOOR BESCHRIJVING
	//Testpad ID: 1
	@Test
	public void testBeschrijvingLeeg() {
		beschrijving="";
		boolean result = v.beschrijving(beschrijving);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testBeschrijvingTeKort() {
		beschrijving="hoi";
		boolean result = v.beschrijving(beschrijving);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testBeschrijvingTeLang() {
		beschrijving="Dit is een beschrijving. Een beschrijving wordt toegevoegd aan een veiling en mag niet te lang zijn omdat het in de database moet passen. Daarom is de grens honderd vijftig tekens";
		boolean result = v.beschrijving(beschrijving);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 4
	@Test
	public void testBeschrijvingCorrect() {
		beschrijving="Dit is een beschrijving";
		boolean result = v.beschrijving(beschrijving);
		assertTrue("failure - should be true", result);
	}
	
}
