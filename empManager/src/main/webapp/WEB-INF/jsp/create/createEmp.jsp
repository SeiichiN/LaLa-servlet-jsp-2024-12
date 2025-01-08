<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp"/>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<main>
			<section class="emp-list">
				<h2>新規社員登録</h2>
				<form action="CreateConfirmServlet" method="post">
					<div>
						ID: <input type="text" name="id"><br>
						名前: <input type="text" name="name"><br>
						年齢: <input type="text" name="age"><br>
					</div>
					<input type="submit" formaction="list" formmethod="get" value="取消">
					<input type="submit" value="確認"> 
				</form>
			</section>
		</main>
		<jsp:include page="../common/aside.jsp"/>	
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>