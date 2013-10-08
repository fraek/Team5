<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Subcategorie overzicht</div>
			<div id="boxBody">
				<table>
					<tr>
						<td width = "25"><b>ID</b></td>
						<td width = "100"><b>Hoofdcategorie</b></td>
						<td width = "75"><b>Naam</b></td>
						<td width = "200"><b>Omschrijving</b></td>
					</tr>
					
					<s:iterator value="alleSubCategorieen">
					<s:url action="EditLidForm.action" var="editURL" namespace="/admin">
					    <s:param name="id"><s:property value="ID" /></s:param>
					</s:url>
					<s:url action="DeleteLidForm.action" var="deleteURL" namespace="/admin">
					    <s:param name="id"><s:property value="ID" /></s:param>
					</s:url>

					<tr>
						<td><s:property value="ID" /></td>
						<td><s:property value="categorie.naam" /></td>
						<td><s:property value="naam" /></td>
						<td><s:property value="omschrijving" /></td>
						<td><a href="<s:property value="#editURL" />"><img src="../img/edit.png"></a></td>
						<td><a href="<s:property value="#deleteURL" />"><img src="../img/delete.png"></a></td>
					</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>