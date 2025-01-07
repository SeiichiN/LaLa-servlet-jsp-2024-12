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
			<section>
				<h1>社員一覧</h1>
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>年齢</th>
						<th class="no-border no-bkcolor"></th>
						<th class="no-border no-bkcolor"></th>
					</tr>
					<c:forEach var="emp" items="${empList}">
						<tr>
							<td><c:out value="${emp.id}"/></td>
							<td><c:out value="${emp.name}"/></td>
							<td><c:out value="${emp.age}"/></td>
							<td class="no-border">
								<form action="update" method="post">
									<input type="hidden" name="id"
									       value="<c:out value="${emp.id}"/>">
									<input class="no-button"
									       type="submit" value="編集">       
								</form>
							</td>
							<td class="no-border">
								<form action="delete" method="post">
									<input type="hidden" name="id" 
									       value="<c:out value="${emp.id}"/>">
									<input class="no-button"
									       type="submit" value="削除">       
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>
	</div><!-- /.container -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>