<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="game.Game" %>
<%
pageContext.setAttribute("ysize", Game.YSIZE - 1);
pageContext.setAttribute("xsize", Game.XSIZE - 1);
%>
<div class="map">
	<h1>MAP</h1>
	<table>
		<c:forEach var="y" begin="0" end="${ysize}" step="1">
			<tr>
			<c:forEach var="x" begin="0" end="${xsize}" step="1">
				<td>
				<c:if test="${player.y == y && player.x == x}">
					プ				
				</c:if>
				</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</div>
    