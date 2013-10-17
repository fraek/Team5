package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorPostcode {
	//test attributen
	private String postcode;
	Validator v = new Validator();

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		postcode = "";
	}

	//TESTS VOOR POSTCODE
	//Testpad ID: 1
	@Test
	public void testPostcodeLeeg() {
		postcode="";
		boolean result = v.postcode(postcode);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testPostcodeOngeldig1() {
		postcode="1111";
		boolean result = v.postcode(postcode);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testPostcodeOngeldig2() {
		postcode="AA1111";
		boolean result = v.postcode(postcode);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 4
	@Test
	public void testPostcodeOngeldig3() {
		postcode="1111A";
		boolean result = v.postcode(postcode);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 5
	@Test
	public void testPostcodeOngeldig4() {
		postcode="111AB";
		boolean result = v.postcode(postcode);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 6
	@Test
	public void testPostcodeOngeldig5() {
		postcode="1111 AB";
		boolean result = v.postcode(postcode);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 7
	@Test
	public void testPostcodeGeldig() {
		postcode="1234AB";
		boolean result = v.postcode(postcode);
		assertTrue("failure - should be true", result);
	}
}
