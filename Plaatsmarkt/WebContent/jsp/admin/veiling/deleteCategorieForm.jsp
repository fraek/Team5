<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Categorie Verwijderen</div>
			<div id="boxBody">
			Weet u zeker dat u deze categorie wilt verwijderen?
			<s:form action="DeleteCategorie.action">
				<s:hidden name="id" value="%{categorie.ID}" />
				<s:submit value="Categorie verwijderen"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>