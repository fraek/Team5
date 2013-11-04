package nl.plaatsmarkt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Validator
public class Validator {
	private Pattern pattern;
	private Matcher matcher;
	
	public boolean email(String email){
		return mail(email);
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
	
	public boolean gebruikersnaam(String gebruikersnaam){
		final String USERNAME_PATTERN = "^[A-Za-z0-9_-]{3,15}$";
		
		pattern = Pattern.compile(USERNAME_PATTERN);
		
		matcher = pattern.matcher(gebruikersnaam);
		return matcher.matches();
	}

	public boolean wachtwoord(String wachtwoord){
		final String PASSWORD_PATTERN="^[A-Za-z0-9]{8,25}$";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(wachtwoord);
		
		final String FALSE1_PATTERN="^[A-Z]{8,25}$", FALSE2_PATTERN="^[a-z]{8,25}$", FALSE3_PATTERN="^[0-9]{8,25}$",
		FALSE4_PATTERN="^[A-Za-z]{8,25}$", FALSE5_PATTERN="^[a-z0-9]{8,25}$", FALSE6_PATTERN="^[0-9A-Z]{8,25}$";
		Matcher matcher1, matcher2, matcher3, matcher4, matcher5, matcher6;
		Pattern pattern1, pattern2, pattern3, pattern4, pattern5, pattern6;
		
		pattern1 = Pattern.compile(FALSE1_PATTERN); matcher1 = pattern1.matcher(wachtwoord);
		pattern2 = Pattern.compile(FALSE2_PATTERN); matcher2 = pattern2.matcher(wachtwoord);
		pattern3 = Pattern.compile(FALSE3_PATTERN); matcher3 = pattern3.matcher(wachtwoord);
		pattern4 = Pattern.compile(FALSE4_PATTERN); matcher4 = pattern4.matcher(wachtwoord);
		pattern5 = Pattern.compile(FALSE5_PATTERN); matcher5 = pattern5.matcher(wachtwoord);
		pattern6 = Pattern.compile(FALSE6_PATTERN); matcher6 = pattern6.matcher(wachtwoord);
		
		if(matcher1.matches() || matcher2.matches() || matcher3.matches() || 
				matcher4.matches() || matcher5.matches() || matcher6.matches()){
			return false;
		}else{
			return matcher.matches();
		}
	}

	public boolean datum(String datum){
		final String DATUM_PATTERN = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)";

		pattern = Pattern.compile(DATUM_PATTERN);

		matcher = pattern.matcher(datum);

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

	public boolean isLeeg(String s){
		if(s == null || s.trim().equals("")){
			return true;
		}
		else return false;
	}
	
	public boolean beschrijving(String s){
		if(s.length() > 150 || s.length() < 5){
			return false;
		}
		else return true;
	}
	
	public boolean bedrag(String bedrag){
		final String BEDRAG_PATTERN = "(^[0-9]{1,}.{0,1}[0-9]{0,2})$";
		pattern = Pattern.compile(BEDRAG_PATTERN);
		matcher = pattern.matcher(bedrag);
		try{
			Double d = Double.parseDouble(bedrag);
			return matcher.matches();
			
		}catch(Exception e){
			return false;
		}
	}
}
