<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="handle">
	<section class="move-btn">
		<h2>移動</h2>
		<form action="MoveServlet" method="post">
			<div class="up-btn">
				<button type="submit" name="dir" value="w">↑</button>
			</div>
			<div class="lr-btn">
				<button type="submit" name="dir" value="a">←</button>
				<button type="submit" name="dir" value="d">→</button>
			</div>
			<div class="down-btn">
				<button type="submit" name="dir" value="s">↓</button>
			</div>
		</form>
	</section>
</div>
    