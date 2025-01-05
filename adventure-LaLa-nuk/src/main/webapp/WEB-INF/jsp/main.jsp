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
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<jsp:include page="map.jsp"/>
		<jsp:include page="info.jsp"/>
		<jsp:include page="handle.jsp"/>
	</div> 
		
	<jsp:include page="footer.jsp"/>
</body>
</html>