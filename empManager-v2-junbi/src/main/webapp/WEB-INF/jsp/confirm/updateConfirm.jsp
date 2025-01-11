<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="updateDone" method="post">
	<input type="hidden" name="id" value="${employee.id}"> 
	<input type="hidden" name="name" value="${employee.name}">
	<input type="hidden" name="age" value="${employee.age}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="更新"> 
</form>
