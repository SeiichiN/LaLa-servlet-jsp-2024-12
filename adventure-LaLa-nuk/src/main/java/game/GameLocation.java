package game;

import java.io.Serializable;
import java.util.Random;

public abstract class GameLocation implements Serializable {
	private int y;
	private int x;
	private Game game;
	
	public GameLocation() {}
	public GameLocation(Game game) {
		this.game = game;
	}
	
	public void setLocation() {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(game.getYsize());
			this.x = rnd.nextInt(game.getXsize());
		} while (!isBlank());
	}

	private boolean isBlank() {
		if (game.getMap()[this.y][this.x].equals(".")) {
			return true;
		}
		return false;
	}
	public void setBlank(GameLocation obj) {
		this.game.getMap()[obj.getY()][obj.getX()] = ".";
	}
	public int getY() { return this.y; }
	public int getX() { return this.x; }
	public void setY(int y) { this.y = y; }
	public void setX(int x) { this.x = x; }
	public Game getGame() {
		return game;
	}
	

}
