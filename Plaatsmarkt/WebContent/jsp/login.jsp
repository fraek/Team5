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
   <s:div>Willekeurige voorbeeld Form</s:div>
   <s:text name="Please fill in the form below:" />
   <s:form action="LoginForm" method="post" enctype="multipart/form-data">
   <s:textfield key="email.from" name="from" />
   <s:password key="email.password" name="password" />
   <s:token />
   <s:submit key="submit" />
   </s:form>
</body>
</html>