<%@include file="/../jsp/guest/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Registreren</div>
			<div id="boxBody">
			<h4>U kunt hier een account aanmaken</h4> 	
	    
		    <hr />
		    
			<s:form action="Register.action">
		   	  <s:textfield name="voornaam" label="Voornaam*" />
		   	  <s:textfield name="tussenvoegsel" label="Tussenvoegsel"/>
		   	  <s:textfield name="achternaam" label="Achternaam*"/>
		   	  <s:textfield name="email1" label="Email*"/>
		   	  <s:textfield name="email2" label="Email* bevestiging"/>
		   	  <s:textfield name="gebruikersnaam" label="Gebruikersnaam**"/>
		   	  <s:password name="wachtwoord1" label="Wachtwoord*"/><!--<s:label cssClass ="infoveld">8 tekens lang, minimaal 1 hoofdletter en 1 cijfer</s:label>-->
		   	  <s:password name="wachtwoord2" label="Wachtwoord* bevestiging"/>
		   	  <s:textfield name="geboortedatum" label="Geboorte Datum*"/>
		   	  <s:textfield name="woonplaats" label="Woonplaats*"/>
		   	  <s:textfield name="postcode" label="Postcode*"/>
		   	  <s:textfield name="adres" label="Adres"/>
		   	  <s:textfield name="telefoonnummer" label="Telefoon nummer*"/>
		   	  <s:submit value="maak account aan"/>
			</s:form>
						<a>Info</a>
			<div class ="infoveld">
			Gebruikersnaam: Geen hoofdletters. Cijfers en _ - toegestaan<br />
			Wachtwoord: 8 tekens lang, minimaal 1 hoofdletter en 1 cijfer<br />
			Geboortedatum: dd/mm/yyyy<br />
			Postcode: 1234AA</div>			
		    <hr /><br/>
			</div>
		</div>    
	    
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="/../jsp/guest/footer.jsp" %>