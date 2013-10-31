<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Categorie Bewerken</div>
			<div id="boxBody">
			Categorie <i><s:property value="categorie.naam"/></i> succesvol bewerkt!	
			<br /><a href="<s:url action='CategorieLijst' namespace="/admin"/>">Naar Categorie Overzicht</a>			
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>