<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<p>以下の社員情報を削除します。</p>
<div>
	ID: <c:out value="${employee.id}"/><br>
	名前: <c:out value="${employee.name}"/><br>
	性別: ${employee.gender == 1 ? '男性' : '女性'}<br>
	年齢: <c:out value="${employee.age}"/><br>
	誕生日: <c:out value="${employee.birthday}"/><br>
	部署: <c:out value="${employee.dept.name}"/>
</div>
<form action="removeDone" method="post">
	<input type="hidden" name="id" value="${employee.id}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="削除"> 
</form>
