<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Categorie Toevoegen</div>
			<div id="boxBody">
			<s:form action="AddCategorie.action">
				<s:textfield name="titel" label="Titel*" />
				<s:textarea name="omschrijving" label="Omschrijving*" />
	   	    <s:submit value="Categorie Toevoegen"/>
			</s:form>
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>