<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
         <title>Een account aanmaken</title>
	</head>

	<body>
	    <h4>Een account aanmaken.</h4> 	
	    
	    <hr />
	    
		<s:form action="Register.action">
    	  <s:textfield name="voornaam" label="Voornaam*"/>
    	  <s:textfield name="tussenvoegsel" label="Tussenvoegsel"/>
    	  <s:textfield name="achternaam" label="Achternaam*"/>
    	  <s:textfield name="email1" label="Email*"/>
    	  <s:textfield name="email2" label="Email* bevestiging"/>
    	  <s:textfield name="gebruikersnaam" label="Gebruikersnaam**"/>
    	  <s:password name="wachtwoord1" label="Wachtwoord*"/>
    	  <s:password name="wachtwoord2" label="Wachtwoord* bevestiging"/>
    	  <s:textfield name="geboortedatum" label="Geboorte Datum*"/>
    	  <s:textfield name="woonplaats" label="Woonplaats*"/>
    	  <s:textfield name="postcode" label="Postcode*"/>
    	  <s:textfield name="adres" label="Adres"/>
    	  <s:textfield name="telefoonnummer" label="Telefoon nummer*"/>
    	  <s:submit value="maak account aan"/>
		</s:form>
		<s:label name="input"></s:label>
			
	    <hr />
	    
	    <a href=" <s:url value="/index.html"/> ">Terug naar Startpagina</a>
	</body> 
</html>