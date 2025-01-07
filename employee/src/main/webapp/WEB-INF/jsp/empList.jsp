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
			<h1>社員一覧</h1>
			<table>
				<tr><th>ID</th><th>名前</th><th>年齢</th>
				     <th class="no-border"></th><th class="no-border"></th></tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td><c:out value="${emp.id}"/></td>
						<td><c:out value="${emp.name}"/></td>
						<td><c:out value="${emp.age}"/></td>
						<td class="no-border">
							<form action="<%=request.getContextPath() %>/update" method="post">
								<input type="hidden" name="id" value='<c:out value="${emp.id}"/>'>
								<button class="img-btn" type="submit">
									<img src="<%=request.getContextPath() %>${pencil_png}" alt="編集">
								</button>
							</form>
						</td>
						<td class="no-border">
							<form action="<%=request.getContextPath() %>/delete" method="post">
								<input type="hidden" name="id" value='<c:out value="${emp.id}"/>'>
								<button class="img-btn" type="submit">
									<img src="<%=request.getContextPath() %>${trash_png}" alt="削除">
								</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${mode == 'search'}">
				<p><a href="${pageContext.request.contextPath}/list">
				      <button>一覧へ</button></a></p>
			</c:if>
		</article>
	</main>

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%= request.getContextPath() %>/js/script.js"></script>
</body>
</html>