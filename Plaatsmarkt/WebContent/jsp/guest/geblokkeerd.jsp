<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Plaatsmarkt</title>
	<link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>

<body>
<div id="wrapper">
<div id="header" onclick="location.href='<s:url action='Index' namespace="/"/>';" style="cursor:pointer;">»Plaatsmarkt</div>
<div id="container">

	<div id="center" class="column">
		<div id="box">
			<div id="boxHead">Geblokkeerd!</div>
			<div id="boxBody">
				Helaas, wegens redenen bent u geblokkeerd op de website.<br/>
				Heeft u vragen, wilt u uitleg of zoekt u naar redenen probeer dan contact op te nemen met de sitebeheer.<br/><br/>
				Excusses voor het ongemak,<br/>
				Met vriendelijke groet Plaatsmarkt.nl
			</div>
		</div>
		
		
	</div>
	<%@include file="../menu.jsp" %>
</div>
</div>
<div id="footer">©Groepje 5 - Thomas Dik, Guido Munk, Willem-Jan Rovers</div>
</body>

</html>