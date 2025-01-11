<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<p>以下の社員情報を削除します。</p>
<form action="removeDone" method="post">
	<div>
		ID: <c:out value="${employee.id}"/><br>
		名前: <c:out value="${employee.name}"/><br>
		年齢: <c:out value="${employee.age}"/><br>
	</div>
	<input type="hidden" name="id" value="${employee.id}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="削除"> 
</form>
