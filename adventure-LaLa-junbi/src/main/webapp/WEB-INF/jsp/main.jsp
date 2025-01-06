<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>アドベンチャーゲーム</title>
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