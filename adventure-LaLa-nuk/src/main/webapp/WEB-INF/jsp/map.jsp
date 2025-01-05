<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="game.Player" %>
<%
Player player = (Player) session.getAttribute("player");
%>
<div class="map">
	<h2>MAP</h2>
	<p>現在:[<%= player.getY() %>, <%= player.getX() %>]</p>
</div>
