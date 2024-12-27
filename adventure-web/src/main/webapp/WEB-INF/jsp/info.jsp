<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="info">
	<h2>INFO</h2>
	<p><c:out value="${msg}"/></p>
	<c:if test="${not empty msgList}">
		<p>
		<c:forEach var="message" items="${msgList}">
			<c:out value="${message}"/><br>
		</c:forEach>
		</p>
	</c:if>
	<c:if test="${not empty monster}">
		<form action="ButtleServlet" method="post">
			<input type="hidden" name="monster" value="${monster}">
			<button type="submit" name="select" value="fight">戦う</button>
			<button type="submit" name="select" value="run">逃げる</button>
		</form>
	</c:if>
	<c:if test="${not empty item}">
		<form action="GetItemServlet" method="post">
			<input type="hidden" name="item" value="${item}">
			<button type="submit" name="select" value="take">拾う</button>
		</form>
	</c:if>
	<c:if test="${player.hp <= 0}">
		<div class="gameover">GAME OVER</div>
		<form action="game" method="post">
			<button type="submit" name="replay" value="yes">再挑戦する</button>
		</form>
	</c:if>
</div>
    