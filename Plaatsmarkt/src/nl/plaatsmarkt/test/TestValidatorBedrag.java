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
		bedrag="";
	}

	//TESTS VOOR BEDRAG
	//Testpad ID: 1
	@Test
	public void testBedragLeeg() {
		bedrag="";
		boolean result = v.bedrag(bedrag);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testBedragMinimaal1Teken() {
		bedrag="a";
		boolean result = v.bedrag(bedrag);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testBedragPuntAlsScheiding() {
		bedrag="1,5";
		boolean result = v.bedrag(bedrag);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 4
	@Test
	public void testBedragMinimaal1TekenVoorPunt() {
		bedrag=".5";
		boolean result = v.bedrag(bedrag);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 5
	@Test
	public void testBedragHoeftNietsAchterPunt() {
		bedrag="1.";
		boolean result = v.bedrag(bedrag);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 6
	@Test
	public void testBedragHoeftGeenPuntAlsErGeenCentenZijn() {
		bedrag="1";
		boolean result = v.bedrag(bedrag);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 7
	@Test
	public void testBedragCorrect() {
		bedrag="12.2";
		boolean result = v.bedrag(bedrag);
		assertTrue("failure - should be true", result);
	}
}
