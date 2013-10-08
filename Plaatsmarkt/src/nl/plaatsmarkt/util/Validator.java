package nl.plaatsmarkt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private Pattern pattern;
	private Matcher matcher;

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
		final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
		
		pattern = Pattern.compile(USERNAME_PATTERN);
		
		matcher = pattern.matcher(gebruikersnaam);
		return matcher.matches();
	}

	public boolean wachtwoord(String wachtwoord){
		if(wachtwoord.length() < 8){
			return false;
		}else{
			int hoofdletters =0;
			int kleineletters =0;
			int cijfers =0;
			for(int i = 0; i < wachtwoord.length(); i++){
				char c = wachtwoord.charAt(i);
				if(Character.isWhitespace(c)){ return false; }
				if(Character.isUpperCase(c)){
					hoofdletters++;
				}
				if(Character.isLowerCase(c)){
					kleineletters++;
				}
				if(Character.isDigit(c)){
					cijfers++;
				}
			}
			if(hoofdletters ==0 || kleineletters ==0 || cijfers ==0){
				return false;
			}else{
				return true;
			}
		}
	}

	public boolean datum(String datum){
		final String DATUM_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

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

}
