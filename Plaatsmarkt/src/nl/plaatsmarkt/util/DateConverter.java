package nl.plaatsmarkt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

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
	
	public java.util.Date stringToDate(String datum){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(datum);
		scanner.useDelimiter("/");
		String dag = scanner.next();
		String maand = scanner.next();
		String jaar = scanner.next();
		int year = Integer.parseInt(jaar);
		int month = Integer.parseInt(maand);
		int day = Integer.parseInt(dag);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd");
		java.util.Date date;
		try {
			date = sdf.parse(year+ ", " + month + ", " + day);
			System.out.println(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String sqlDateToString(java.sql.Date sqlDate){
		java.util.Date utilDate = this.sqlToUtil(sqlDate);
		return utilDateToString(utilDate);
	}
	
	public String utilDateToString(java.util.Date utilDate){
		String s = utilDate.toString();
		return s;
	}
	
	public String dateToString(Object o){
		if(o instanceof java.util.Date){
			return utilDateToString((java.util.Date)o);
		}
		if(o instanceof java.sql.Date){
			return utilDateToString((java.sql.Date)o);
		}
		else return "Invalid Date";
	}
}
