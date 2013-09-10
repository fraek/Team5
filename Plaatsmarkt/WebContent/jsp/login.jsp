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
   <s:div>Welkom bij Plaatsmarkt</s:div>
   <s:text name="Inloggen:" />
   <s:form action="LoginForm" method="post" enctype="multipart/form-data">
   <s:textfield key="email" name="mail" />
   <s:password key="wachtword" name="password" />
   <s:token />
   Nog geen account?<a href="/registreren.jsp">klik hier</a>om in te loggen!
   <s:submit key="submit" />
   </s:form>
</body>
</html>