<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="info">
	<h2>INFO</h2>
	
	<c:if test="${not empty msgList}">
		<ul>
			<c:forEach var="msg" items="${msgList}">
				<li><c:out value="${msg}"/></li>
			</c:forEach>
		</ul>
	</c:if>
</div>