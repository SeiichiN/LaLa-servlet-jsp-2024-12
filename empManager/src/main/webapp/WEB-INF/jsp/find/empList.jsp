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
				<h2>社員一覧</h2>
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>年齢</th>
						<th class="no-border"></th>
						<th class="no-border"></th>
					</tr>
					<c:forEach var="emp" items="${empList}">
						<tr>
							<td><c:out value="${emp.id}"/></td>
							<td><c:out value="${emp.name}"/></td>
							<td><c:out value="${emp.age}"/></td>
							<td class="no-border">
								<form action="UpdateServlet" method="post">
									<button type="submit" name="id" 
									        value="${emp.id}">編集</button>
								</form>
							</td>
							<td class="no-border">
								<form action="RemoveServlet" method="post">
									<button type="submit" name="id" 
									        value="${emp.id}">削除</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>