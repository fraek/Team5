<%@include file="/../jsp/guest/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">CategoriŽn Lijst</div>
			<div id="boxBody">
				<table>
					<tr>
						<td width = "25"><b>ID</b></td>
						<td width = "150"><b>Naam</b></td>
						<td width = "300"><b>Omschrijving</b></td>
					</tr>
					
					<s:iterator value="alleCategorieen">
					<tr>
						<td><s:property value="ID"/></td>
						<td><a href="<s:url namespace="/" action="SubCategorieLijst"><s:param name="id" value="ID" /></s:url>"><s:property value="naam"/></a></td>
						<td><s:property value="omschrijving" /></td>
					</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="/../jsp/guest/footer.jsp" %>