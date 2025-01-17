<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="createDone" method="post">
	<input type="hidden" name="id" value="${employeeForm.id}"> 
	<input type="hidden" name="name" value="${employeeForm.name}">
	<input type="hidden" name="gender" value="${employeeForm.gender}">
	<input type="hidden" name="birthday" value="${employeeForm.birthday}">
	<input type="hidden" name="deptId" value="${employeeForm.deptId}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="登録"> 
</form>
