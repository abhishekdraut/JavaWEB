<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello!!${sessionScope.user.user.name}, This is home page for
		management system.</h1>
	<h1>${sessionScope.user.fetchAllUser()}</h1>
	<table style="background-color: lightgrey; margin: auto; width: 100%;">
		<caption>User Data</caption>
		<tr>
			<th style="border: 2px solid black">User Id</th>
			<th style="border: 2px solid black">Name</th>
			<th style="border: 2px solid black">Email</th>
			<th style="border: 2px solid black">Date</th>
			<th style="border: 2px solid black">Reg Amount</th>
			<th style="border: 2px solid black">Role</th>
			<th style="border: 2px solid black" colspan="2">Action</th>
		</tr>
		<c:forEach var="item" items="${sessionScope.user.allUserData}">
			<tr>
				<td style="border: 1px solid black">${item.getUserId()}</td>
				<td style="border: 1px solid black">${item.getName()}</td>
				<td style="border: 1px solid black">${item.getEmail()}</td>
				<td style="border: 1px solid black">${item.getDate()}</td>
				<td style="border: 1px solid black">${item.getRegAmount()}</td>
				<td style="border: 1px solid black">${item.getRole()}</td>
				<td
					style="border: 1px solid black; text-align: center; background-color: powderblue;">
					<a href="edit.jsp">Edit</a>
				</td>
				<td
					style="border: 1px solid black; text-align: center; background-color: #ff7043">
					<a
					href="<c:url value="delete.jsp"> <c:param name="userId" value="${item.getUserId()}"></c:param> </c:url>">
						Delete</a>

				</td>
			</tr>
		</c:forEach>




	</table>



</body>
</html>