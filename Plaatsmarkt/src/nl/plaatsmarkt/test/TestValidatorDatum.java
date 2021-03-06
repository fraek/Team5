package nl.plaatsmarkt.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.plaatsmarkt.util.DateConverter;
import nl.plaatsmarkt.util.Validator;

import org.junit.Before;
import org.junit.Test;


public class TestValidatorDatum {
	//test attributen
	private String datum;
	private Validator v = new Validator();

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
	@Test
	public void testDatumtestje1(){
		DateConverter dc = new DateConverter();
		String datumstr="31-02-2000";
		java.util.Date datumpje = dc.stringToDate(datumstr);
		assertTrue("failure - should be true", dc.datePassed(datumpje));
	}
	@Test
	public void testDatumtestje2(){
		DateConverter dc = new DateConverter();
		String datumstr="21-02-2015";
		java.util.Date datumpje = dc.stringToDate(datumstr);
		assertTrue("failure - should be true", dc.datePassed(datumpje));
	}
}
