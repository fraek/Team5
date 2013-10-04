<%@include file="../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Succesvol uitgelogd!</div>
			<div id="boxBody">
				U bent succesvol uitgelogd!<br/>
				Tot ziens <s:property value="gebruiker.gebruikersnaam"/>!
			</div>
		</div>
	</div>
	
	
	<%@include file="../menu.jsp" %>
</div>
<%@include file="../member/footer.jsp" %>