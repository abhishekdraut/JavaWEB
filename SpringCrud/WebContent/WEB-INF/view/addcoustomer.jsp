<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addcoustomer" modelAttribute="coustomer" method="post">
<form:hidden path="id" />
<table>
<tr>
<td><label>Enter Name</label></td>
<td><form:input path="fname"/></td>
</tr>
<tr>
<td><label>Enter Last Name</label></td>
<td><form:input path="lname"/></td>
</tr>
<tr>
<td><label>Enter email</label></td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="submit"></td>
</tr>
</table>


</form:form>
</body>
</html>