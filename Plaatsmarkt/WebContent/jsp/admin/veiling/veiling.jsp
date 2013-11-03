<%@include file="/../jsp/admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Subcategoriën Lijst</div>
			<div id="boxBody">
				<table>
					<tr>
						<td width = "25"><b>ID</b></td>
						<td width = "100"><b>Titel</b></td>
						<td width = "200"><b>Beschrijving</b></td>
						<td width = "100"><b>Aanbieder</b></td>
						<td width = "100"><b>Aanmaak Datum</b></td>
						<td width = "100"><b>Verloop Datum</b></td>
					</tr>
					
					<tr>
						<td><s:property value="deVeiling.ID" /></td>
						<td><s:property value="deVeiling.titel"/></td>
						<td><s:property value="deVeiling.beschrijving" /></td>
						<td><s:property value="deVeiling.deAanbieder.gebruikersnaam" /></td>
						<td><s:property value="deVeiling.aanmaakDatum" /></td>
						<td><s:property value="deVeiling.verloopDatum"/></td>
					</tr>
				</table>
				<s:form action="AddBod.action">
					<s:textfield name="bedrag" label="Bedrag*" />
			   	    <s:submit value="Bieden"/>
				</s:form>
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="/../jsp/admin/footer.jsp" %>