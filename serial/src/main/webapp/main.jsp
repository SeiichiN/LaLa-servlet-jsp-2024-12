<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
List<String> msgList_a = (List<String>)request.getAttribute("msgList_a");
List<String> msgList_b = (List<String>)request.getAttribute("msgList_b");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (msgList_a != null){
	for (String s : msgList_a) { %>
		<p><%= s %></p>
<%
	}
}
%>
<%
if (msgList_b != null){
	for (String s : msgList_b) { %>
		<p><%= s %></p>
<%
	}
}
%>
</body>
</html>