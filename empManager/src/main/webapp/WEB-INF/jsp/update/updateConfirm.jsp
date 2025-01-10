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
				
				<div>
					ID:   <c:out value="${employee.id}"/><br>
					名前: <c:out value="${employee.name}"/><br>
					年齢: <c:out value="${employee.age}"/>
				</div>

				<form action="UpdateDoneServlet" method="post">
					<input type="hidden" name="id" value="${employee.id}"> 
					<input type="hidden" name="name" value="${employee.name}">
					<input type="hidden" name="age" value="${employee.age}">
					<a href="list"><button type="button">取消</button></a>
					<input type="submit" value="更新"> 
				</form>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>