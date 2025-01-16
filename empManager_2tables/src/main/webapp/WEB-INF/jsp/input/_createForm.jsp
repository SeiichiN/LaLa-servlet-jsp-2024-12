<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<form action="createConfirm" method="post">
	<div>
		名前: <input type="text" name="name" 
		             value="<c:out value="${employeeForm.name}"/>"><br>
		性別: <input type="radio" name="gender" value="1"
		             ${employeeForm.gender == 1 ? 'checked' : '' }>男性
		      <input type="radio" name="gender" value="2"
		             ${employeeForm.gender == 2 ? 'checked' : '' }>女性<br>
		誕生日: <input type="text" name="birthday" 
		               value="<c:out value="${employeeForm.birthday}"/>">
		               (例 1999/07/12)<br>
		部署:  <select name="deptId">
		       		<c:forEach var="dept" items="${deptList}">
		       			<option value="${dept.id}" 
		       			      ${employeeForm.dept.id == dept.id ? 'selected' : ''}>
		       			  <c:out value="${dept.name}"/>
		       			</option>
		       		</c:forEach>
		       </select>
	</div>
	<input type="submit" formaction="list" formmethod="get" value="取消">
	<input type="submit" value="確認"> 
</form>