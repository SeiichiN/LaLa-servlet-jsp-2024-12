<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String result = (String) request.getAttribute("result");
String result2 = (String) request.getAttribute("result2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん結果</title>
</head>
<body>
	<h1>じゃんけん結果</h1>
	<p><%= result2 %></p>
	<p><%= result %></p>
	<p><a href="index.jsp">もう一度</a></p>
</body>
</html>