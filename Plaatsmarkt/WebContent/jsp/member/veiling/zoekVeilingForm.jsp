<%@include file="/../jsp/guest/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Zoek een Veiling!</div>
			<div id="boxBody">
			<s:form action="ZoekVeiling.action">
				<s:textfield name="titel" label="Titel*" />
			<s:submit value="Zoek"/>
			</s:form>		
			</div>
		</div>
		
		
	</div>
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="/../jsp/guest/footer.jsp" %>