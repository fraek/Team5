<%@include file="../../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Mijn Veilingen</div>
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
					
					<s:if test="%{alleVeilingenEigenaar.isEmpty()}">
				    <tr>
				        <td colspan="6">Nog geen veilingen</td>
				    </tr>
					</s:if>
					<s:else>
						<s:iterator value="alleVeilingenEigenaar">
						<tr>
							<td><s:property value="ID" /></td>
							<td><a href="<s:url namespace="/member" action="DeVeiling"><s:param name="id" value="ID" /></s:url>"><s:property value="titel"/></a></td>
							<td><s:property value="beschrijving" /></td>
							<td><s:property value="deAanbieder.gebruikersnaam" /></td>
							<td><s:property value="aanmaakDatum" /></td>
							<td><s:property value="verloopDatum"/></td>
						</tr>
						</s:iterator>
					</s:else>
				</table>
			</div>
		</div>
	</div>
	
	
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../member/footer.jsp" %>