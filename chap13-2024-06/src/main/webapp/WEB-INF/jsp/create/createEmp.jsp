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
				<form action="createConfirm" method="post">
					<table>
						<tr>
							<th>ID</th>
							<td><input type="text" name="id" 
												value="<c:out value="${emp.id}"/>" 
							           class="no-border"></td>
						</tr>
						<tr>
							<th>名前</th>
							<td><input type="text" name="name"
												value="<c:out value="${emp.name}"/>" 
							           class="no-border"></td>
						</tr>
						<tr>
							<th>年齢</th>
							<td><input type="text" name="age"
												value="<c:out value="${emp.age}"/>" 
							           class="no-border"></td>
						</tr>
					</table>
					<div class="button-area">
						<div><a href="getList"><button type="button">戻る</button></a></div>
						<div><input type="submit" value="確認"></div>
					</div>
				</form>
				
				<c:if test="${not empty errorList}">
					<ul>
						<c:forEach var="error" items="${errorList}">
							<li class="error"><c:out value="${error}"/></li>
						</c:forEach>
					</ul>
				</c:if>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>
	</div><!-- /.container -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>