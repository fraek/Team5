<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Subcategorie Toevoegen</div>
			<div id="boxBody">
			<s:form action="AddSubCategorie.action">
				<s:textfield name="titel" label="Titel*" />
				<s:textarea name="omschrijving" label="Omschrijving*" />
				<select name="Categorie" id="Categorie" label="Categorie*"> 
					<option value="bing.com">bing.com</option> 
					<option value="yahoo.com">yahoo.com</option> 
					<option value="baidu.com">baidu.com</option> 
				</select> 
	   	    <s:submit value="Subcategorie Toevoegen"/>
			</s:form>
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>