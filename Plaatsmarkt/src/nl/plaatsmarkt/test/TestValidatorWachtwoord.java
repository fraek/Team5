package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorWachtwoord {
	//test attributen
	private String wachtwoord;
	Validator v = new Validator();

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		wachtwoord = "";
	}

	//TESTS VOOR WACHTWOORD
	//Testpad ID: 1
	@Test
	public void testWachtwoordLeeg() {
		wachtwoord="";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testWachtwoordZonderCijfer() {
		wachtwoord="Wachtwoord";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testWachtwoordZonderHoofdletter() {
		wachtwoord="wachtwoord1";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 4
	@Test
	public void testWachtwoordZonderKleineletter() {
		wachtwoord="WACHTWOORD1";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 5
	@Test
	public void testWachtwoordTeKort() {
		wachtwoord="Wacht1";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 6
	@Test
	public void testWachtwoordTeLang() {
		wachtwoord="WachtwoordWachtwoord123456";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 7
	@Test
	public void testWachtwoordMetTekens() {
		wachtwoord="Wachtwoord!@$";
		boolean result = v.wachtwoord(wachtwoord);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 8
	@Test
	public void testWachtwoordGeldig() {
		wachtwoord="Wachtwoord1";
		boolean result = v.wachtwoord(wachtwoord);
		assertTrue("failure - should be true", result);
	}
}
