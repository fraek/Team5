package nl.plaatsmarkt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//DateConverter
public class DateConverter {

	public DateConverter() {
	}
	
	public java.sql.Date utilToSql(java.util.Date utilDate){
		java.sql.Date sqlDatum;
	    sqlDatum = new java.sql.Date(utilDate.getTime());
	    return sqlDatum;
	}
	
	public java.util.Date sqlToUtil(java.sql.Date sqlDate){
		java.util.Date utilDatum;
		utilDatum = new java.util.Date(sqlDate.getTime());
		return utilDatum;
	}

	public String sqlDateToString(java.sql.Date sqlDate){
		java.util.Date utilDate = this.sqlToUtil(sqlDate);
		return utilDateToString(utilDate);
	}
	
	@SuppressWarnings("deprecation")
	public java.util.Date timestampToDate(java.sql.Timestamp timestamp){
		java.util.Date datum = null;
		datum = new java.util.Date(timestamp.getYear(), timestamp.getMonth(), 
				timestamp.getDate(), timestamp.getHours(), timestamp.getMinutes(), timestamp.getSeconds());
		return datum;
	}

	@SuppressWarnings("deprecation")
	public String utilDateToString(java.util.Date utilDate){
		java.util.Date date = utilDate;
		String s = "";
		int day = date.getDate();
		int month = date.getMonth()+1;
		int year = date.getYear()+1900;
		String dag = "";
		String maand = "";
		if(day < 10){
			dag += "0"+day;
		}else{
			dag += day;
		}
		if(month < 10){
			maand +="0"+month;
		}else{
			maand += month;
		}
		s += dag+"-"+maand+"-"+year;
		return s;
	}
	
	public String dateToString(Object o){
		if(o instanceof java.util.Date){
			return utilDateToString((java.util.Date)o);
		}
		if(o instanceof java.sql.Date){
			return sqlDateToString((java.sql.Date)o);
		}
		else return "Invalid Date";
	}
	
	public java.util.Date stringToDate(String datum){
		SimpleDateFormat formatdash = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = formatdash.parse(datum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date; 
	}
	
	public boolean datePassed(java.util.Date datum){
		boolean b = false;
		java.util.Date date = new java.util.Date();
		if(datum.compareTo(date)>0){
    		b = false;
    		System.out.println(datum.toString() + " is later dan " + date.toString() + " return false");
    	}else if(datum.compareTo(date)<0){
    		b = true;
    		System.out.println(datum.toString() + " is eerder dan " + date.toString() + " return true");
    	}else if(datum.compareTo(date)==0){
    		b = false;
    		System.out.println(datum.toString() + " is hetzelfde als " + date.toString() + "return false");
    	}
		return b;
	}
}
