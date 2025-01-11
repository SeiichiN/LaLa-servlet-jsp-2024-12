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
				<h2><c:out value="${title_h2}"/></h2>
				
				<div>
					ID:  <c:out value="${employee.id}"/><br>
					名前: <c:out value="${employee.name}"/><br>
					年齢: <c:out value="${employee.age}"/>
				</div>

				<jsp:include page="${confirm_jspfile}"/>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>