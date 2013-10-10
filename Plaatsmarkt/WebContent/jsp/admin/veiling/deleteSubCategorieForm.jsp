<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Subcategorie Verwijderen</div>
			<div id="boxBody">
			Weet u zeker dat u deze subcategorie wilt verwijderen?
			<s:form action="DeleteSubCategorie.action">
				<s:hidden name="id" value="%{subcategorie.id}" />
					Test:<s:property value="%{subcategorie.ID}"/>
				<s:submit value="Subcategorie verwijderen"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>