<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Fruit" %>
<%
Fruit fruit = (Fruit)session.getAttribute("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= fruit.getName() %> : <%= fruit.getPrice() %>
</body>
</html>