package nl.plaatsmarkt.test;

import static org.junit.Assert.*;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestSubCategorie {
	//test attributen
	private String datum;
	private SubCategorie subcategorie;

	//testgegevens maken
	@Before
	public void setUp() throws Exception {
		datum = "";
	}

	//TESTS VOOR Datum
	//Testpad ID: 1
	@Test
	public void testDatumLeeg() {
		datum="";
		boolean result = v.datum(datum);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 2
	@Test
	public void testDatumZonderCijfers() {
		datum="dd-MM-yyyy";
		boolean result = v.datum(datum);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 3
	@Test
	public void testDatumOngeldigeDeelstreep() {
		datum="06/11/1994";
		boolean result = v.datum(datum);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 4
	@Test
	public void testDatumGeldig() {
		datum="06-11-1994";
		boolean result = v.datum(datum);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 5
	@Test
	public void testDatumGeldigSchrikkeljaar() {
		datum="29-02-2012";
		boolean result = v.datum(datum);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 6
	@Test
	public void testDatumOngeldigSchrikkeljaar() {
		datum="29-02-2011";
		boolean result = v.datum(datum);
		assertFalse("failure - should be false", result);
	}
	//Testpad ID: 7
	@Test
	public void testDatumDagBestaat() {
		datum="31-01-2000";
		boolean result = v.datum(datum);
		assertTrue("failure - should be true", result);
	}
	//Testpad ID: 8
	@Test
	public void testDatumDagBestaatNiet() {
		datum="31-02-2000";
		boolean result = v.datum(datum);
		assertFalse("failure - should be false", result);
	}
}
