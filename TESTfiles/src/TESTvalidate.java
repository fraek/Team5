

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TESTvalidate {
	private Pattern pattern;
	private Matcher matcher;
	
	public static void main(String[] arg){
		TESTvalidate v = new TESTvalidate();
		System.out.println("email-postcode tests");
		System.out.println("test 1: thomas@thomas.nl        "+v.mail("thomas@thomas.nl"));
		System.out.println("test 2: @thomas.nl              "+v.mail("@thomas.nl"));
		System.out.println("test 3: thomas@                 "+v.mail("thomas@"));
		System.out.println("test 4: @.nl                    "+v.mail("@.nl"));
		System.out.println("test 5: thomas@.nl              "+v.mail("thomas@.nl"));
		System.out.println("test 5: 12w643exsu@1234r65tf.nl "+v.mail("12w643exsu@1234r65tf.nl"));
		System.out.println("test 6: t?[][@34#$%.vr          "+v.mail("t?[][@34#$%.vr"));
		System.out.println("test 7: Willem9@ballaaa.nl      "+v.mail("Willem9@ballaaa.nl"));
		System.out.println("test 8: abc defg@hij.kl         "+v.mail("abc defg@hij.kl"));
		System.out.println("--------------------------------------");
		System.out.println("test 1: 1234aa                  "+v.postcode("1234aa"));
		System.out.println("test 2: aa1234                  "+v.postcode("aa1234"));
		System.out.println("test 3: 12a34a                  "+v.postcode("12a34a"));
		System.out.println("test 4: 1a                      "+v.postcode("1a"));
		System.out.println("test 5: 123aa                   "+v.postcode("123aa"));
		System.out.println("test 6: 4444pp                  "+v.postcode("4444pp"));
		System.out.println("test 7: 0234lk                  "+v.postcode("0234lk"));
		System.out.println("--------------------------------------");
		System.out.println("--- convert util to sql ---");
		java.util.Date utilDate = new java.util.Date();
		System.out.println("util date:        "+utilDate);
		java.sql.Date sqlDate = v.getSql(utilDate);
		System.out.println("converted to sql: "+sqlDate);
		System.out.println("--- convert sql to util ---");
		System.out.println("sql date:          "+sqlDate);
		java.util.Date date = v.getUtil(sqlDate);
		System.out.println("converted to util: "+date);
		System.out.println("--------------------------------------");
		System.out.println("test 1: 06-11-1994   "+v.geboorteDatum("31-11-1994"));
		System.out.println("test 2: 05-11-1990   "+v.geboorteDatum("05-11-1990"));
		System.out.println("test 3: 1670-21.23   "+v.geboorteDatum("1670-21.23"));
		System.out.println("test 4: geboortedate "+v.geboorteDatum("geboortedate"));
		System.out.println("test 5: ab-cd-efgh   "+v.geboorteDatum("ab-cd-efgh"));
		System.out.println("test 6: 11/12/1222   "+v.geboorteDatum("11/12/1222"));
		System.out.println("test 7: 32-10-2013   "+v.geboorteDatum("32-10-2013"));
		System.out.println("-----------Date to String-------------");
		java.util.Date dat = new java.util.Date();
		System.out.println("dateu1 : "+ dat);
		String dat2 = "15-11-1994";
		java.util.Date dat3 = v.stringToDate(dat2);
		System.out.println("dateu2 : " + dat3);
		System.out.println("dates1: " +v.utilToSql(dat));
		System.out.println("dates2: " +v.utilToSql(dat3));
		System.out.println("string1: "+v.dateToString(dat));
		System.out.println("string2: "+v.dateToString(dat3));
		System.out.println("string1: "+v.dateToString(dat));
		System.out.println("string2: "+v.dateToString(dat3));
		System.out.println("sqlstr1: "+v.dateToString(v.utilToSql(dat)));
		System.out.println("sqlstr2: "+v.dateToString(v.utilToSql(dat3)));
		System.out.println("--------------Time & Timestamps-------");
		
	}

	public TESTvalidate() {
		// TODO Auto-generated constructor stub
	}

	public boolean mail(String email){
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		pattern = Pattern.compile(EMAIL_PATTERN);

		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public boolean postcode(String postcode){
		final String POST_PATTERN = "^[1-9][0-9]{3}[a-zA-Z]{2}$";

		pattern = Pattern.compile(POST_PATTERN);

		matcher = pattern.matcher(postcode);
		return matcher.matches();
	}
	
	public java.sql.Date getSql(java.util.Date utilDate){
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    return sqlDate;
	}
	
	public java.util.Date getUtil(java.sql.Date sqlDate){
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	public boolean geboorteDatum(String geboorteDatum){
		final String GEBOORTEDATUM_PATTERN = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)";

		pattern = Pattern.compile(GEBOORTEDATUM_PATTERN);

		matcher = pattern.matcher(geboorteDatum);

		if(matcher.matches()){

			matcher.reset();

			if(matcher.find()){

				String dag = matcher.group(1);
				String maand = matcher.group(2);
				int jaar = Integer.parseInt(matcher.group(3));
				//de maanden 1,3,5,7,8,10,12 hebben 31 dagen.
				if (dag.equals("31") && (maand.equals("4") || maand .equals("6") || maand.equals("9") || maand.equals("11") || maand.equals("04") || maand .equals("06") || maand.equals("09"))) {
					return false;
				} else if (maand.equals("2") || maand.equals("02")) {
					//Schrikkeljaar
					if(jaar % 4==0){
						if(dag.equals("30") || dag.equals("31")){
							return false;
						}else{
							return true;
						}
					}else{
						if(dag.equals("29")||dag.equals("30")||dag.equals("31")){
							return false;
						}else{
							return true;
						}
					}
				}else{				 
					return true;				 
				}
			}else{
				return false;
			}		  
		}else{
			return false;
		}			    
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

}
