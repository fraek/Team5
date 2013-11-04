<%@include file="../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Welkom Lid!</div>
			<div id="boxBody">
				U bent succesvol ingelogd <s:property value="#session['gebruiker'].gebruikersnaam"/><br />
				Ga naar het overzicht om veilingen te bekijken en te bieden!<br />
				<a href="<s:url namespace="/member" action="VeilingOverzicht"/>">Veiling Overzicht</a>
			</div>
		</div>
	</div>
	
	
	<%@include file="../menu.jsp" %>
</div>
<%@include file="../member/footer.jsp" %>