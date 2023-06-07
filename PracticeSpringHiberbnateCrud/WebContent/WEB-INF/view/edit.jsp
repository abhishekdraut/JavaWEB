<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="SubmitForm" method="post">
		<input type="hidden" name="formId" value="${user.userId}"/>
		<table style="background-color: lightgrey; margin: auto">
			
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="formEmail"
					value="${user.email}" /></td>
			</tr>

			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="formName"
					value=" ${user.name}" /></td>
			</tr>
			<tr>
				<td>Enter RegAmount</td>
				<td><input type="number" name="formAmount"
					value="${user.amount}" /></td>
			</tr>
			<tr>
				<td>Enter date</td>
				<td><input type="text" name="formDate"
					value="${user.date}" /></td>
			</tr>
			<tr>
				<td>Enter Role</td>
				<td><input type="text" name="formRole"
					value="${user.role}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>