<%@include file="/../jsp/guest/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Inloggen</div>
			<div id="boxBody">
				<s:property value="geslaagd"/>
				
				<h4>U kunt hier inloggen</h4> 	
	    
		    	<hr />
				<s:form action="Login.action">
				 	<s:textfield name="gebruikersnaam" label="Gebruikersnaam**"/>
		   	 		 <s:password name="wachtwoord" label="Wachtwoord*"/>
					<s:submit value="Inloggen" />
				</s:form>
				<hr />
				
				Nog geen account?<br />
			<a href="<s:url value="Register.action"/>">Klik hier</a> om te registreren!<br /><br />
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="/../jsp/guest/footer.jsp" %>