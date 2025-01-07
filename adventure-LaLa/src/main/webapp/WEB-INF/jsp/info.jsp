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
	
	<c:if test="${thing == 'goblin' || thing == 'dragon'}">
		<form action="ButtleServlet" method="post">
			<button type="submit" name="select" value="fight">戦う</button>
			<button type="submit" name="select" value="run">逃げる</button>
		</form>
	</c:if>
	
	<c:if test="${thing == 'potion' || thing == 'ether'}">
		<form action="GetItemServlet" method="post">
			<button type="submit" name="select" value="take">拾う</button>
			<button type="submit" name="select" value="nothing">何もしない</button>
		</form>
	</c:if>
	
	
</div>