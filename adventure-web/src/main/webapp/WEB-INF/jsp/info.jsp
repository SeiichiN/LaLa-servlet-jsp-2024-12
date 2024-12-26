<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
String thing = (String) request.getAttribute("thing");
if (thing != null) {
	if (thing.equals("goblin") || thing.equals("dragon")) {
		pageContext.setAttribute("monster", thing);
	} else if (thing.equals("potion") || thing.equals("ether")) {
		pageContext.setAttribute("item", thing);
	}
}
%>
<div class="info">
	<h2>INFO</h2>
	<p><c:out value="${msg}"/></p>
	<c:if test="${not empty monster}">
		<form action="ButtleServlet" method="post">
			<button type="submit" name="select" value="fight">戦う</button>
			<button type="submit" name="select" value="run">逃げる</button>
		</form>
	</c:if>
	<c:if test="${not empty item}">
		<form action="GetItemServlet" method="post">
			<button type="submit" name="select" value="take">拾う</button>
		</form>
	</c:if>
</div>
    