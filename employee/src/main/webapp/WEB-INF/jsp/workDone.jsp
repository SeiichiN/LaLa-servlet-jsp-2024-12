<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/common/head.jsp"/>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

	<main id="main">
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		<article id="main-content">
			<h1>${title}</h1>
			<c:if test="${not empty msg}">
				<p>${msg}</p>
			</c:if>
			<a href="${pageContext.request.contextPath}/list">一覧へ</a>
		</article>
	</main>

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%= request.getContextPath() %>/js/script.js"></script>
</body>
</html>