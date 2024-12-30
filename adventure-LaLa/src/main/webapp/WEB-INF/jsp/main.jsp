<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="game.Player" %>
<%
Player player = (Player) session.getAttribute("player");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>現在:[<%= player.getY() %>, <%= player.getX() %>]</p>
	
	<form action="MoveServlet" method="post">
		<button type="submit" name="dir" value="n">↑</button>
		<button type="submit" name="dir" value="w">←</button>
		<button type="submit" name="dir" value="e">→</button>
		<button type="submit" name="dir" value="s">↓</button>
	</form>
</body>
</html>