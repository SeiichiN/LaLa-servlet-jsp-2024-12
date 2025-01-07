<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員情報管理システム</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/table.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container center-align">
		<main>
			<section class="input-area">
				<h1>新規社員登録</h1>

				<p><c:out value="${msg}"/></p>
				<p>
					<a href="getList">
						<button type="button">一覧へ</button>
					</a>
				</p>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>
	</div><!-- /.container -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>