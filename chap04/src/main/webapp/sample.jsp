<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<% String name = "綾部 みゆき"; %>
<% int age = new Random().nextInt(30); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPのサンプル</title>
</head>
<body>
	私の名前は<%= name %>。年齢は<%= age %>才です。
</body>
</html>