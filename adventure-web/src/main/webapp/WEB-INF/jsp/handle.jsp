<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="handle">
	<section class="move-btn">
		<h2>MOVE</h2>
		<div class="movebtn-area">
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
		</div><!-- movebtn-area -->
	</section>
	<section class="status">
		<h2>STATUS</h2>
		<div class="player-hp">
			HP:${player.hp}
		</div>
		<div class="player-inventory">
			持ち物：
			<form action="UseItemServlet" method="post">
				<ul>
				<c:forEach var="item" items="${player.itemList}">
					<li>
						<label>
							<input type="radio" name="item" value="${item.type}">${item.type}
						</label>
					</li>
				</c:forEach>
				</ul>
				<input type="submit" value="使う">
			</form>
		</div>
	</section>
</div>
    