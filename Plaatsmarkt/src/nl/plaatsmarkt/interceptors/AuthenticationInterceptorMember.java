package nl.plaatsmarkt.interceptors;

import java.util.Map;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.util.GebruikerAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AuthenticationInterceptorMember implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {

		@SuppressWarnings("rawtypes")
		Map session = actionInvocation.getInvocationContext().getSession();
		
		Gebruiker gebruiker = (Gebruiker) session.get("gebruiker");
		
		if (gebruiker == null){
		    return Action.LOGIN;
		} 
		else {
				
		    Action action = ( Action ) actionInvocation.getAction();
		    
		    if (action instanceof GebruikerAware) {
		        ((GebruikerAware)action).setGebruiker(gebruiker);
		    }
		    
		    return actionInvocation.invoke();
		}
	}
}
