package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorEmail {
	//test attributen
	private String mail;
	private Validator v = new Validator();

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		mail = "";
	}

	//TESTS VOOR EMAIL
	//Testpad ID: 1
	@Test
	public void testEmailLeeg() {
		mail="";
		boolean result = v.mail(mail);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testEmailOngeldig1() {
		mail="mail.com";
		boolean result = v.mail(mail);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testEmailOngeldig2() {
		mail="mail@mail";
		boolean result = v.mail(mail);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 4
	@Test
	public void testEmailOngeldig3() {
		mail="mail mail.com";
		boolean result = v.mail(mail);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 5
	@Test
	public void testEmailGeldig() {
		mail="mail@mail.com";
		boolean result = v.mail(mail);
		assertTrue("failure - should be true", result);
	}
}
