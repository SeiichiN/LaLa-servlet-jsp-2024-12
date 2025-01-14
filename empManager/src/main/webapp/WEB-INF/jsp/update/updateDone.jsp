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
				<h2>社員情報更新・結果</h2>
				<p>
					<c:if test="${not empty msg}">
						<c:out value="${msg}"/>
					</c:if>
				</p>
				<div>
					<a href="list">
						<button type="button">一覧へ</button>
					</a>
				</div>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>