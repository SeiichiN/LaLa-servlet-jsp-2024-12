<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<aside>
	<h2>補助機能</h2>
	<p><a href="createInput"><button>新規登録</button></a></p>
	<div class="find-name">
		<form action="findByName" method="post">
			<input type="text" name="name" placeholder="名前">
			<input type="submit" value="検索">
		</form>
	</div>
	<div class="find-dept">
		<form action="findByDeptId" method="post">
			<select name="deptId">
				<c:forEach var="dept" items="${deptList}">
					<option value="${dept.id}"><c:out value="${dept.name}"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="検索">
		</form>
	</div>

</aside>