<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
				
<form action="createConfirm" method="post">
	<div>
		ID: <input type="text" name="id" 
		           value="<c:out value="${employee.id}"/>"><br>
		名前: <input type="text" name="name" 
		             value="<c:out value="${employee.name}"/>"><br>
		年齢: <input type="text" name="age" 
		             value="<c:out value="${employee.age}"/>"><br>
	</div>
	<input type="submit" formaction="list" formmethod="get" value="取消">
	<input type="submit" value="確認"> 
</form>
