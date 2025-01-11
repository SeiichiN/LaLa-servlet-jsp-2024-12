<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
				
<form action="updateConfirm" method="post">
	<div>
		ID: <c:out value="${employee.id}"/><br>
		名前: <input type="text" name="name" 
		             value="<c:out value="${employee.name}"/>"><br>
		年齢: <input type="text" name="age" 
		             value="<c:out value="${employee.age}"/>"><br>
	</div>
	<input type="hidden" name="id" value="${employee.id}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="確認"> 
</form>
