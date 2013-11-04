<%@ page import="nl.plaatsmarkt.domain.Gebruiker" %>

<div id="menu" class="column">
      <h2>»Menu</h2>
      
	<%  
	Gebruiker geb = (Gebruiker)session.getAttribute("gebruiker");
    if ((session.getAttribute("gebruiker") != null) && geb.getGebruikerRol().toString().equalsIgnoreCase("member")) {  
    %> 	<!--  Als iemand als member ingelogd is -->
    	<i>Welkom <s:property value="#session['gebruiker'].gebruikersnaam"/></i><br/><br/>
    	<b>Veilingen</b><br/>
	  	<a href="<s:url action='CategorieLijst' namespace="/member"/>">Categoriën</a><br/>
	  	<!-- <a href="<s:url action='SubCategorieLijst' namespace="/"/>">Subcategoriën</a><br/> -->
	    <a href="<s:url action='ZoekVeilingForm' namespace="/"/>">Veiling Zoeken</a><br/>
	    <a href="<s:url action='AddVeilingForm' namespace="/member"/>">Veiling Toevoegen</a><br/>
	    <a href="<s:url action='MijnVeilingen' namespace="/member"><s:param name='id' value='#session["gebruiker"].ID' /></s:url>">Mijn Veilingen</a><br/><br/>
	    <a href="<s:url namespace="/member" action="VeilingOverzicht"/>">Veiling Overzicht</a>
	    <b>Account</b><br/>
	    <a href="<s:url action='MyAccount' namespace="/member"/>">Mijn Account</a><br/>
	    <a href="#"><del>Inbox</del></a><br/>
	    <a href="<s:url action='Logout' namespace="/member"/>">Uitloggen</a><br/>
    <% 
    }else if ((session.getAttribute("gebruiker") != null) && geb.getGebruikerRol().toString().equalsIgnoreCase("admin")) {
  	%>	<!--  Als iemand als admin ingelogd is -->
  		<i>Welkom <s:property value="#session['gebruiker'].gebruikersnaam"/></i><br/><br/>
    	<b>Veilingen</b><br/>
	  	<a href="<s:url action='CategorieLijst' namespace="/"/>">Categoriën</a><br/>
	  	<!-- <a href="<s:url action='SubCategorieLijst' namespace="/"/>">Subcategoriën</a><br/> -->
	    <a href="<s:url action='ZoekVeilingForm' namespace="/"/>">Veiling Zoeken</a><br/>
	    <a href="<s:url action='AddVeilingForm' namespace="/member"/>">Veiling Toevoegen</a><br/>
	    <a href="<s:url action='MijnVeilingen' namespace="/member"/>">Mijn Veilingen</a><br/><br/>
	    
	    <b>Admin</b><br/>
	    <a href="<s:url action='CategorieLijst' namespace="/admin"/>">Categorie Overzicht</a><br/>
	  	<a href="<s:url action='AddCategorieForm' namespace="/admin"/>">Categorie Toevoegen</a><br/><br/>
	    <a href="<s:url action='SubCategorieLijst' namespace="/admin"/>">Subcategorie Overzicht</a><br/>
	    <a href="<s:url action='AddSubCategorieForm' namespace="/admin"/>">Subcategorie Toevoegen</a><br/><br/>
	    <a href="<s:url action='LedenLijst' namespace="/admin"/>">Lid Overzicht</a><br/>
	    <a href="<s:url action='AddLid' namespace="/admin"/>">Lid Toevoegen</a><br/><br/>
	    
	    <b>Account</b><br/>
	    <a href="<s:url action='MyAccount' namespace="/member"/>">Mijn Account</a><br/>
	    <a href="#"><del>Inbox</del></a><br/>
	    <a href="<s:url action='Logout' namespace="/member"/>">Uitloggen</a><br/>
  	<%
    }else{
  	%> 	<!--  Als iemand niet is ingelogd -->
  		<b>Veilingen</b><br/>
  		<a href="<s:url action='CategorieLijst' namespace="/"/>">Categoriën</a><br/>
	  	<!-- <a href="<s:url action='SubCategorieLijst' namespace="/"/>">Subcategoriën</a><br/> -->
	    <a href="<s:url action='ZoekVeilingForm' namespace="/"/>">Veiling Zoeken</a><br/><br/>
	    
	    <b>Account</b><br/>
	  	<a href="<s:url action='Login' namespace="/"/>">Inloggen</a><br/>
	    <a href="<s:url action='Register' namespace="/"/>">Registeren</a><br/>
	    
  	<%
  	 }
  	%>

</div>