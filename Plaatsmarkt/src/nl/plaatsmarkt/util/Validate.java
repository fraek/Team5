package nl.plaatsmarkt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	public boolean mail(String email){
		Pattern pattern;
		Matcher matcher;
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		pattern = Pattern.compile(EMAIL_PATTERN);

		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public boolean postcode(String postcode){
		Pattern pattern;
		Matcher matcher;
		final String POST_PATTERN = "^[1-9][0-9]{3}[a-zA-Z]{2}$";

		pattern = Pattern.compile(POST_PATTERN);

		matcher = pattern.matcher(postcode);
		return matcher.matches();
	}
}
