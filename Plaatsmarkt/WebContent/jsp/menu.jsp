<%@ page import="nl.plaatsmarkt.domain.Gebruiker" %>

<div id="menu" class="column">
      <h2>»Menu</h2>
      
	<%  
	Gebruiker geb = (Gebruiker)session.getAttribute("gebruiker");
    if ((session.getAttribute("gebruiker") != null) && geb.getGebruikerRol().toString().equalsIgnoreCase("member")) {  
    %> 	<!--  Als iemand als member ingelogd is -->
    	<i>Welkom <s:property value="#session['gebruiker'].gebruikersnaam"/></i><br/><br/>
    	<b>Veilingen</b><br/>
	  	<a href="#">Categoriën</a><br/>
	    <a href="#">Veiling Zoeken</a><br/>
	    <a href="#">Mijn Veilingen</a><br/><br/>
	    
	    <b>Account</b><br/>
	    <a href="<s:url action='MyAccount' namespace="/member"/>">Mijn Account</a><br/>
	    <a href="#">Inbox</a><br/>
	    <a href="<s:url action='Logout' namespace="/member"/>">Uitloggen</a><br/>
    <% 
    }else if ((session.getAttribute("gebruiker") != null) && geb.getGebruikerRol().toString().equalsIgnoreCase("admin")) {
  	%>	<!--  Als iemand als admin ingelogd is -->
  		<i>Welkom <s:property value="#session['gebruiker'].gebruikersnaam"/></i><br/><br/>
    	<b>Veilingen</b><br/>
	  	<a href="#">Categoriën</a><br/>
	    <a href="#">Veiling Zoeken</a><br/>
	    <a href="#">Mijn Veilingen</a><br/><br/>
	    
	    <b>Admin</b><br/>
	    <a href="#">Categorie Overzicht</a><br/>
	  	<a href="#">Categorie Toevoegen</a><br/><br/>
	    <a href="#">Subcategorie Overzicht</a><br/>
	    <a href="#">Subcategorie Toevoegen</a><br/><br/>
	    <a href="#">Lid Overzicht</a><br/>
	    <a href="#">Lid Toevoegen</a><br/><br/>
	    
	    <b>Account</b><br/>
	    <a href="<s:url action='MyAccount' namespace="/member"/>">Mijn Account</a><br/>
	    <a href="#">Inbox</a><br/>
	    <a href="<s:url action='Logout' namespace="/member"/>">Uitloggen</a><br/>
  	<%
    }else{
  	%> 	<!--  Als iemand niet is ingelogd -->
  		<b>Veilingen</b><br/>
  		<a href="#">Categoriën</a><br/>
	    <a href="#">Veiling Zoeken</a><br/><br/>
	    
	    <b>Account</b><br/>
	  	<a href="<s:url action='Login' namespace="/"/>">Inloggen</a><br/>
	    <a href="<s:url action='Register' namespace="/"/>">Registeren</a><br/>
	    
  	<%
  	 }
  	%>

</div>