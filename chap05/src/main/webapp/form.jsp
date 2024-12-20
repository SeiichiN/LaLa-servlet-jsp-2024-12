<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
String sushi = URLEncoder.encode("すし", "UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録もどき</title>
</head>
<body>
	<form action="FormServlet" method="post">
		名前：<input type="text" name="name"><br>
		性別：<input type="radio" name="gender" value="0">男性
		      <input type="radio" name="gender" value="1">女性<br>
		      <input type="hidden" name="food" value="curry">
		<input type="submit" value="登録">
	</form>
	<p><a href="GetServlet?food=<%= sushi %>">ゲットで送信</a></p>
</body>
</html>