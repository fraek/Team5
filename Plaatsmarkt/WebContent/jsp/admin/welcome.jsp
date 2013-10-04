<%@include file="../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Welkom ADMIN!</div>
			<div id="boxBody">
				U bent succesvol ingelogd <s:property value="gebruiker.gebruikersnaam"/>
			</div>
		</div>
		
		
	</div>
	<%@include file="../menu.jsp" %>
</div>
<%@include file="../member/footer.jsp" %>