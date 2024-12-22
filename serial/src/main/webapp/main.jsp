<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Hero,beans.Matango,main.SerializableRW" %>
<%@ page import="java.util.List" %>
<%
Hero hero = (Hero) SerializableRW.readObj("hero.obj");
Matango m = (Matango) SerializableRW.readObj("matango.obj");
List<String> msgList_a = hero.attack(m);
List<String> msgList_b = m.attack(hero);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>