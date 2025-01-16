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
				
				<c:if test="${not empty errorMsgList}">
					<ul>
						<c:forEach var="errorMsg" items="${errorMsgList}">
							<li class="error"><c:out value="${errorMsg}"/></li>
						</c:forEach>
					</ul>
				</c:if>
				
				<jsp:include page="_createForm.jsp"/>

			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>