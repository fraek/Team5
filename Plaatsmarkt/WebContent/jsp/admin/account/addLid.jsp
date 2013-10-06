<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Lid Toevoegen</div>
			<div id="boxBody">
			<s:form action="AddLid.action">
		   	  <s:textfield name="voornaam" label="Voornaam*" />
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
		   	  <s:submit value="Voeg lid toe"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>