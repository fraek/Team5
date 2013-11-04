<%@include file="/../jsp/member/header.jsp"%>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Veiling overzicht</div>
			<div id="overzichtBody">
				<s:iterator value="veilingOverzicht">
					<div id="veiling">
						<table>
							<tr><td><a href="<s:url namespace="/member" action="DeVeiling"><s:param name="id" value="ID" /></s:url>"><img src="/Plaatsmarkt/img/Default.png" id="veilingImg"/></a></td></tr>
							<tr><td><a href="<s:url namespace="/member" action="DeVeiling"><s:param name="id" value="ID" /></s:url>"><s:property value="titel" /></a></tr>
							<tr><td><s:property value="beschrijving" /></td></tr>
							<tr><td><s:property value="deAanbieder.gebruikersnaam" /></td></tr>
							<tr><td><s:property value="aanmaakDatum" /></td></tr>
							<tr><td><s:property value="verloopDatum" /></td></tr>
						</table>
					</div>
				</s:iterator>
			</div>
		</div>


	</div>
	<%@include file="../../menu.jsp"%>
</div>
<%@include file="/../jsp/member/footer.jsp"%>