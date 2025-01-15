<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
				
<form action="updateConfirm" method="post">
	<div>
		ID: <c:out value="${employee.id}"/><br>
		名前: <input type="text" name="name" 
		             value="<c:out value="${employee.name}"/>"><br>
		性別: <input type="radio" name="gender" value="1" 
		            ${employee.gender == 1 ? 'checked' : ''}>男性
		      <input type="radio" name="gender" value="2"
		               ${employee.gender == 2 ? 'checked' : ''}>女性<br>
		誕生日: <input type="text" name="birthday" 
						value="<c:out value="${employee.birthday}"/>"><br>
		部署: <select name="deptId">
				<c:forEach var="dept" items="${deptList}">
					<option value="${dept.id}" ${dept.id == employee.dept.id ? 'selected' : ''}>
						<c:out value="${dept.name}"/>
					</option>
				</c:forEach>
			  </select>
	</div>
	<input type="hidden" name="id" value="${employee.id}">
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="確認"> 
</form>
