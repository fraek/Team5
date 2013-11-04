package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorBedrag {
	//test attributen
	private String bedrag;
	private double db;
	Validator v = new Validator();

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		bedrag = "";
	}

	//TESTS VOOR BEDRAG
	//Testpad ID: 1
	@Test
	public void testBedragLeeg() {
		bedrag="";
		boolean result = v.bedrag(bedrag);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 1
	@Test
	public void testBedragCorrect() {
		bedrag="12.2";
		boolean result = v.bedrag(bedrag);
		System.out.println(bedrag);
		db = Double.parseDouble(bedrag);
		assertTrue("failure - should be true", result);
	}
}
