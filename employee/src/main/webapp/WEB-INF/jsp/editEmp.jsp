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
			<c:if test="${not empty errMsgList}">
				<ul>
				<c:forEach var="errMsg" items="${errMsgList}">
					<li class="error">${errMsg}</li>		
				</c:forEach>
				</ul>
			</c:if>
			<form action="${pageContext.request.contextPath}${gotoUrl}" method="post">
				<table>
					<tr>
						<th>ID</th>
						<td>
							<c:choose>
								<c:when test="${mode == 'update'}">
									<c:out value="${emp.id}" />
									<input type="hidden" name="id"
							       		   value='<c:out value="${emp.id}" />'>
								</c:when>
								<c:otherwise>
									<input class="indata" type="text" name="id"
							               value='<c:out value="${emp.id}" />'>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>名前</th>
						<td>
							<input class="indata" type="text" name="name"
							       value='<c:out value="${emp.name}" />'>
						</td>
					</tr>
					<tr>
						<th>年齢</th>
						<td>
							<input class="indata" type="text" name="age"
							       value='<c:out value="${emp.age}" />'>
						</td>
					</tr>
				</table>
				<button class="submit-btn" type="submit">確認</button>
				<a href="<%= request.getContextPath() %>/list">
				<button class="cancel-btn" type="button">戻る</button></a>
			</form>
		</article>
	</main>

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%= request.getContextPath() %>/js/script.js"></script>
</body>
</html>