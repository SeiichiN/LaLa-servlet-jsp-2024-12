<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp"/>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<main>
			<section class="emp-list">
				<h2>社員情報削除</h2>
				<p>以下の社員情報を削除します。</p>
				<form action="RemoveDoneServlet" method="post">
					<div>
						ID: <c:out value="${employee.id}"/><br>
						名前: <c:out value="${employee.name}"/><br>
						年齢: <c:out value="${employee.age}"/><br>
					</div>
					<input type="hidden" name="id" value="${employee.id}">
					<a href="list"><button type="button">取消</button></a>
					<input type="submit" value="削除"> 
				</form>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>