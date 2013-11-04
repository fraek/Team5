<%@include file="../../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Bod Toevoegen</div>
			<div id="boxBody">
				Je hebt een bod toegevoegd
				<br /><a href="<s:url namespace="/member" action="DeVeiling"><s:param name="id" value="ID" /></s:url>">Terug naar de Veiling</a>
				<br /><a href="<s:url action='CategorieLijst' namespace="/member"/>">Terug naar de Categorieën</a>
			</div>
		</div>
	</div>
	
	
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../member/footer.jsp" %>