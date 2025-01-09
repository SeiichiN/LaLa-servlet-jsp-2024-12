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
				<h2>社員情報更新・確認</h2>
				<form action="UpdateDoneServlet" method="post">
					<div>
						ID: <c:out value="${employee.id }"/><br>
						名前: <c:out value="${employee.name}"/><br>
						年齢: <c:out value="${employee.age}"/><br>
					</div>
					<input type="hidden" name="id" 
					       value="${employee.id}"><br>
					<input type="hidden" name="name"
					       value="${employee.name}"><br>
					<input type="hidden" name="age"
					       value="${employee.age}"><br>
					<input type="submit" value="戻る" 
					       formaction="UpdateConfirmServlet">
					<input type="submit" value="確認"> 
				</form>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>