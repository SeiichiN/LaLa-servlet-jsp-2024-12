<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
				
<form action="createConfirm" method="post">
	<div>
		名前: <input type="text" name="name" 
		             value="<c:out value="${employeeForm.name}"/>"><br>
		性別: <label>
				<input type="radio" name="gender" value="1" 
		            ${employeeForm.gender == 1 ? 'checked' : ''}>男性
		     </label>
		     <label>
		      <input type="radio" name="gender" value="2"
		               ${employeeForm.gender == 2 ? 'checked' : ''}>女性<br>
		     </label>
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
	<a href="list"><button type="button">取消</button></a>
	<input type="submit" value="確認"> 
</form>
