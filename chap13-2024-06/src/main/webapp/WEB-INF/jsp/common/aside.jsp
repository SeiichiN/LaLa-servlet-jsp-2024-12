<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside>
	<h2>補助機能</h2>
	<ul>
		<li><a href="create">新規登録</a></li>
		<li>
			<form action="findName" method="post">
				<input type="text" name="name"
				       placeholder="名前検索">
				<input type="submit" value="検索">
			</form>
		</li>
	</ul>
</aside>