<%@include file="/jsp/guest/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Inloggen</div>
			<div id="boxBody">
				<s:property value="geslaagd"/>
				
				<s:div>Welkom bij Plaatsmarkt</s:div>
				<s:text name="Inloggen:" />
				<s:form action="LoginForm.action" method="post" enctype="multipart/form-data"><br />
					<s:textfield key="gebruikersnaam" name="gebruikersnaam" label="Gebruikersnaam"/>
					<s:password key="wachtwoord" name="wachtwoord" label="Wachtwoord"/>
					<s:token />
					<s:submit key="submit" />
				</s:form>
				Nog geen account?<br />
			<a href="<s:url value="/jsp/guest/registreren.jsp"/>">Klik hier</a> om te registreren!<br />
			</div>
		</div>
		
		
	</div>
	<%@include file="/jsp/guest/menu.jsp" %>
</div>
<%@include file="/jsp/guest/footer.jsp" %>