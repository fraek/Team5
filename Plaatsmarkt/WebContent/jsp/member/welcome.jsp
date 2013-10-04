<%! Gebruiker gebruiker=session.getAttribute("gebruiker"); %>
<%@include file="../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Welkom Lid!</div>
			<div id="boxBody">
				U bent succesvol ingelogd <%=username %>
			</div>
		</div>
	</div>
	
	
	<%@include file="../menu.jsp" %>
</div>
<%@include file="../member/footer.jsp" %>