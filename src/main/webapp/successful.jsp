<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful</title>
</head>
<body>
	<h1>Welcome <%=session.getAttribute("username") %> to our website!</h1>
	<div>password: <%=request.getAttribute("password") %></div>
	<a href="product.jsp">Go to product page</a>
</body>
</html>