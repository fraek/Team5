<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Subcategorie Bewerken</div>
			<div id="boxBody">
			<s:form action="EditSubCategorie.action">
				<s:textfield name="naam" label="Naam*" value="%{subcategorie.naam}"/>
				<s:textarea name="omschrijving" label="Omschrijving*" value="%{subcategorie.omschrijving}"/>
				<s:select name="categorie" label="Categorieën*" list="alleCategorieen" listValue="naam" listKey="ID"/>
				<s:hidden name="id" value="%{subcategorie.ID}" />
				<s:submit value="Bewerk Subcategorie"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>