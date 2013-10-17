package nl.plaatsmarkt.test;

import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidator {
	//test attributen
	String mail, postcode, gebruikersnaam, wachtwoord, datum;
	Validator v;
	
	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		v = new Validator();
	}
	
	//Testpad ID: 1
	@Test
	public void testTESTOMSCHRIJVING() {
		
	}
	
}
