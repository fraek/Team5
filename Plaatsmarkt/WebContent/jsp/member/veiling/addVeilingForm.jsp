<%@include file="../../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Veiling Toevoegen</div>
			<div id="boxBody">
			<s:form action="AddVeiling.action">
				<s:textfield name="titel" label="Titel*" />
				<s:textarea name="omschrijving" label="Omschrijving*" />
				<s:select label ="Sub Categorie" list="subcats" name="subcats" listValue="naam" listKey="ID"/>
				<s:textfield name="verloopDatum" label="Verloop Datum*" value="dd-mm-yyyy"/>
	   	    <s:submit value="Veiling Toevoegen"/>
			</s:form>		
			</div>
		</div>
	</div>
	
	
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../member/footer.jsp" %>