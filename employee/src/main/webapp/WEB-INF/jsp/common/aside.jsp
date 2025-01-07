<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside id="sub-content">
	<h2><span id="menu-btn">メニュー</span></h2>
	<div id="menu-area">
 		<ul>
 			<li><a class="newEmp" href="<%= request.getContextPath() %>/input">新規社員登録</a></li>
 			<li>
 				<form action="${pageContext.request.contextPath}/search"
 				      method="post" class="search-form">
 					<input class="search-box" type="text" name="name" placeholder="名前">
 					<button class="img-btn" type="submit">
 						<img src="${pageContext.request.contextPath}${find_png}"
 					    	 alt="検索" class="search-img">
 					</button>
 				</form>
 			</li>
 		</ul>
		
	</div>
</aside>
