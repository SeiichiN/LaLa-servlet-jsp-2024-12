<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>画像アップロード</h1>
	<form action="main" method="post" enctype="multipart/form-data">
	画像:<input type="file" name="pict"><br>
	<button type="submit">送信</button>
	</form>
</body>
</html>