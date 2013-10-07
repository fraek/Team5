package nl.plaatsmarkt.util;


public class DateConverter {
	//private java.util.Date utilDatum;
	//private java.sql.Date sqlDatum;

	public DateConverter() {
	}
	
	public java.sql.Date getSql(java.util.Date utilDate){
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    return sqlDate;
	}
	
	public java.util.Date getUtil(java.sql.Date sqlDate){
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}

}
