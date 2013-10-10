<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Categorie Bewerken</div>
			<div id="boxBody">
			<s:form action="EditCategorie.action">
				<s:textfield name="naam" label="Naam*" value="%{categorie.naam}"/>
				<s:textarea name="omschrijving" label="Omschrijving*" value="%{categorie.omschrijving}"/>
				<s:hidden name="id" value="%{categorie.ID}" />
				<s:submit value="Bewerk Categorie"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>