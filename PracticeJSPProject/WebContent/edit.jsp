<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sessionScope.user.GetUser(param.userId)}


	<form action="submitForm.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="formEmail"
					value="${sessionScope.user.selectedUser.email}" /></td>
			</tr>

			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="formName"
					value=" ${sessionScope.user.selectedUser.name}" /></td>
			</tr>
			<tr>
				<td>Enter RegAmount</td>
				<td><input type="number" name="formAmount"
					value="${sessionScope.user.selectedUser.amount}" /></td>
			</tr>
			<tr>
				<td>Enter date</td>
				<td><input type="text" name="formDate"
					value="${sessionScope.user.selectedUser.date}" /></td>
			</tr>
			<tr>
				<td>Enter Role</td>
				<td><input type="text" name="formRole"
					value="${sessionScope.user.selectedUser.role}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>