<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-coustomer</title>
</head>
<body>
<button type="button" onclick="window.location.href='addform'">Add Coustomer</button>

<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="i" items="${coustomer}">
<tr>
<td>${i.fname}</td>
<td>${i.lname}</td>
<td>${i.email}</td>
<td><form action="editform?id=${i.id}" method="post"><input type="submit" value="EDIT"></form></td>
<td><form action="deleterec?id=${i.id}" method="post"><input type="submit" value="Delete"></form></td>
</tr>

</c:forEach>
</table>


</body>
</html>