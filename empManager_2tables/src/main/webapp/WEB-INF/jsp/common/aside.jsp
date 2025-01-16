<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside>
	<h2>補助機能</h2>
	<p><a href="createInput"><button>新規登録</button></a></p>
	<div class="find-name">
		<form action="FindNameServlet" method="post">
			<input type="text" name="name" placeholder="名前">
			<input type="submit" value="検索">
		</form>
	</div>
</aside>