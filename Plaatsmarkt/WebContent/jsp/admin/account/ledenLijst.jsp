<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Ledenlijst</div>
			<div id="boxBody">
				<table>
					<tr>
						<td width = "25"><b>ID</b></td>
						<td width = "75"><b>Naam</b></td>
						<td width = "25"></td>
						<td width = "75"><b>Achternaam</b></td>
						<td width = "95"><b>Gebruikersnaam</b></td>
						<td width = "150"><b>E-Mail Adres</b></td>
						<td width = "130"><b>Adres</b></td>
						<td width = "55"><b>Postcode</b></td>
						<td width = "65"><b>Woonplaats</b></td>
						<td width = "95"><b>Telefoonnummer</b></td>
						<td width = "55" colspan="3"><b>Rechten</b></td>
					</tr>
					
					<s:iterator value="alleGebruikers">
					<s:url action="EditLidForm.action" var="editURL" namespace="/admin">
					    <s:param name="id"><s:property value="ID" /></s:param>
					</s:url>
					<s:url action="DeleteLidForm.action" var="deleteURL" namespace="/admin">
					    <s:param name="id"><s:property value="ID" /></s:param>
					</s:url>

					<tr>
						<td><s:property value="ID" /></td>
						<td><s:property value="voornaam" /></td>
						<td><s:property value="tussenvoegsel" /></td>
						<td><s:property value="achternaam" /></td>
						<td><s:property value="gebruikersnaam" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="adres" /></td>
						<td><s:property value="postcode" /></td>
						<td><s:property value="woonplaats" /></td>
						<td>0<s:property value="telefoonnummer" /></td>
						<td><s:property value="gebruikerRol" /></td>
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