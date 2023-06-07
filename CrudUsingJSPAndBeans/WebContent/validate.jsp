<%@page import="beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>

<jsp:setProperty property="email" name="user" />
<jsp:setProperty property="password" name="user" />

<body>

	<%-- <%
		String s1 =user.validateUser();
	%> --%>
	<%-- ${sessionScope.user.getError()} --%>
	<%-- <% out.print("Thiasdbb"+s1); %> --%>

	<%-- <%
		response.sendRedirect(s1 + ".jsp");
	%> --%>
<c:redirect url="${sessionScope.user.validateUser()}.jsp"></c:redirect>
</body>
</html>