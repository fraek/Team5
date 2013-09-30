<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<title>Inloggen</title>
</head>
<body>
	<s:property value="geslaagd"/>

   <s:div>Welkom bij Plaatsmarkt</s:div>
   <s:text name="Inloggen:" />
   <s:form action="LoginForm.action" method="post" enctype="multipart/form-data"><br />
   <s:textfield key="email" name="mail" />
   <s:password key="wachtwoord" name="password" />
   <s:token />
   <s:submit key="submit" />
   </s:form>
   Nog geen account?<br />
   <a href="<s:url value="/jsp/guest/registreren.jsp"/>">Klik hier</a> om te registreren!<br />
</body>
</html>