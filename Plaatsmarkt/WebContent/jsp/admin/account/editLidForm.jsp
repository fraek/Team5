<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Lid Bewerken</div>
			<div id="boxBody">
			<s:form action="EditLid.action">
				<s:textfield name="voornaam" label="Voornaam*" value="%{gebruiker.voornaam}"/>
				<s:textfield name="tussenvoegsel" label="Tussenvoegsel" value="%{gebruiker.tussenvoegsel}"/>
				<s:textfield name="achternaam" label="Achternaam*" value="%{gebruiker.achternaam}"/>
				<s:textfield name="email1" label="Email*" value="%{gebruiker.email}"/>
				<s:textfield name="email2" label="Email* bevestiging"/>
				<s:textfield name="gebruikersnaam" label="Gebruikersnaam*" value="%{gebruiker.gebruikersnaam}"/>
				<s:password name="wachtwoord1" label="Wachtwoord*"/>
				<s:password name="wachtwoord2" label="Wachtwoord* bevestiging"/>
				<s:textfield name="geboortedatum" label="Geboorte Datum*" value="%{gebruiker.geboortedatum}"/>
				<s:textfield name="woonplaats" label="Woonplaats*" value="%{gebruiker.woonplaats}"/>
				<s:textfield name="postcode" label="Postcode*" value="%{gebruiker.postcode}"/>
				<s:textfield name="adres" label="Adres" value="%{gebruiker.adres}"/>
				<s:textfield name="telefoonnummer" label="Telefoon nummer*" value="%{gebruiker.telefoonnummer}"/>
				<s:select key="rol" list="rechtenlijst" label="Rechten"/>
				<s:hidden name="id" value="%{gebruiker.ID}" />
				<s:submit value="Bewerk Lid"/> <s:property value="%{gebruiker.gebruikerRol}"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>