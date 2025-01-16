<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
				
<form action="updateConfirm" method="post">
	<div>
		ID: <c:out value="${employeeForm.id}"/><br>
		名前: <input type="text" name="name" 
		             value="<c:out value="${employeeForm.name}"/>"><br>
		性別: <input type="radio" name="gender" value="1" 
		            ${employeeForm.gender == 1 ? 'checked' : ''}>男性
		      <input type="radio" name="gender" value="2"
		               ${employeeForm.gender == 2 ? 'checked' : ''}>女性<br>
		誕生日: <input type="text" name="birthday" 
						value="<c:out value="${employeeForm.birthday}"/>"><br>
		部署: <select name="deptId">
				<c:forEach var="dept" items="${deptList}">
					<option value="${dept.id}" ${dept.id == employeeForm.deptId ? 'selected' : ''}>
						<c:out value="${dept.name}"/>
					</option>
				</c:forEach>
			  </select>
	</div>
	<input type="hidden" name="id" value="${employeeForm.id}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="確認"> 
</form>
