<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="handle">
	<h2>操作</h2>
	<form action="MoveServlet" method="post">
		<div class="button-area">
			<div class="up-btn">
				<button type="submit" name="dir" value="n">↑</button>
			</div>
			<div class="lr-btn">
				<button type="submit" name="dir" value="w">←</button>
				<button type="submit" name="dir" value="e">→</button>
			</div>
			<div class="down-btn">
				<button type="submit" name="dir" value="s">↓</button>
			</div>
		</div>
	</form>

</div>