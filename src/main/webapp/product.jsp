<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product</title>
</head>
<body>
	<h1>welcome <%=session.getAttribute("username") %></h1>
	<div>password: <%=request.getAttribute("password") %></div>
	<a href="successful.jsp">Back to homepage</a>
	<a href="login.jsp">Back to login page</a>
</body>
</html>