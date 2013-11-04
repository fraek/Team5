<%@include file="/../jsp/guest/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Veiling</div>
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
				<table>
					<tr>
						<td width = "100"><b>Biedingen</b></td>
					</tr>
				<s:if test="%{deVeiling.alleBiedingen.isEmpty()}">
			    <tr>
			        <td>Nog geen biedingen</td>
			    </tr>
				</s:if>
				<s:else>
					<s:iterator value="deVeiling.alleBiedingen">
						<tr>
							<td><s:property value="deBieder.voornaam"/></td>
							<td><s:property value="Bedrag"/></td>
						</tr>
					</s:iterator>
				</s:else>
				</table>
				<a href="<s:url namespace="/" action="Login"/>">Log in</a> of <a href="<s:url namespace="/" action="Register"/>">Registreer</a> om te kunnen bieden.
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="/../jsp/guest/footer.jsp" %>