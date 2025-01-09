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
				<h2>社員情報編集</h2>

				<c:if test="${not empty errorMsgList}">
					<ul>
						<c:forEach var="errorMsg" items="${errorMsgList}">
							<li class="error">${errorMsg}</li>						
						</c:forEach>
					</ul>
				</c:if>
				
				<form action="UpdateConfirmServlet" method="post">
					<div>
						ID: <c:out value="${employee.id}"/><br>
						名前: <input type="text" name="name"
						           value="<c:out value="${employee.name}"/>"><br>
						年齢: <input type="text" name="age"
						           value="<c:out value="${employee.age}"/>"/><br>
					</div>
					<input type="hidden" name="id" value="${employee.id}">
					<a href="list"><button type="button">取消</button></a>
					<input type="submit" value="確認"> 
				</form>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>