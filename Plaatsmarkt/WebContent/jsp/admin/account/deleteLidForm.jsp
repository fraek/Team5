<%@include file="../../admin/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Lid Verwijderen</div>
			<div id="boxBody">
			Weet u zeker dat u dit lid wilt verwijderen?
			<s:form action="DeleteLid.action">
				<s:hidden name="id" value="%{gebruiker.ID}" />
				<s:submit value="Lid verwijderen"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../admin/footer.jsp" %>