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
				<h1>新規社員確認</h1>
				<table>
					<tr>
						<th>ID</th>
						<td><c:out value="${emp.id}"/></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><c:out value="${emp.name}"/></td>
					</tr>
					<tr>
						<th>年齢</th>
						<td><c:out value="${emp.age}"/></td>
					</tr>
				</table>
				<form action="createRegister" method="post">
					<input type="hidden" name="id" value="<c:out value="${emp.id}"/>">
					<input type="hidden" name="name" value="<c:out value="${emp.name}"/>">
					<input type="hidden" name="age" value="<c:out value="${emp.age}"/>">
					<div class="button-area">
						<div><input type="submit" value="戻る" formaction="create"></div>
						<div><input type="submit" value="登録"></div>
					</div>
				</form>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>
	</div><!-- /.container -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>