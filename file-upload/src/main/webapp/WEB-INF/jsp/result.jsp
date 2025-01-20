<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	  画像:<br>
	  <img src="<%= request.getContextPath() %>/upload/${filename}" alt="">
	</p>
</body>
</html>