<%@include file="../../member/header.jsp" %>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Veiling Toevoegen</div>
			<div id="boxBody">
			<s:form action="AddVeiling.action">
				<s:textfield name="titel" label="Titel*" />
				<s:textarea name="omschrijving" label="Omschrijving*" />
				<select name="subcategorie" id="subcategorie" label="Subcategorie*"> 
					<option value="bing.com">bing.com</option> 
					<option value="yahoo.com">yahoo.com</option> 
					<option value="baidu.com">baidu.com</option> 
				</select> 
	   	    <s:submit value="Veiling Toevoegen"/>
			</s:form>		
			</div>
		</div>
	</div>
	
	
	<%@include file="../../menu.jsp" %>
</div>
<%@include file="../../member/footer.jsp" %>