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
					<c:if test="${employeeForm.id > 0}">
					ID:   <c:out value="${employeeForm.id}"/><br>
					</c:if>
					名前: <c:out value="${employeeForm.name}"/><br>
					性別: <c:out value="${employeeForm.gender == 1 ? '男性' : '女性'}"/><br>
					誕生日: <c:out value="${employeeForm.birthday}"/><br>
					部署: <c:forEach var="dept" items="${deptList}">
					      	<c:if test="${dept.id == employeeForm.deptId}">
					      	  <c:out value="${dept.name}"/>
					      	</c:if>
					      </c:forEach>
				</div>

				<jsp:include page="${confirm_form}"/>

			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>