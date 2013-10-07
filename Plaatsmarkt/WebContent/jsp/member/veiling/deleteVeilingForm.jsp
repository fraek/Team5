<%@include file="../../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Veiling Verwijderen</div>
			<div id="boxBody">
			<s:form action="DeleteVeiling.action">
				Veiling Naam: Naam<br/>
				Veiling Omschrijving: Omschrijving<br/>
				Veiling geplaats op: XX-XX-XXXX<br/>
				Veiling loopt af op: XX-XX-XXXX<br/>
				Veiling geplaatst door: U<br/>
				<s:hidden name="id" value="%{veiling.ID}" />
	   	    <s:submit value="Veiling Verwijderen"/>
			</s:form>		
			</div>
		</div>
	</div>
	
	
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../member/footer.jsp" %>