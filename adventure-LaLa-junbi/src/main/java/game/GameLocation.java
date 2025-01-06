package game;

import java.util.Random;

public abstract class GameLocation {
	private int y;
	private int x;
	
	public void setLocation() {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(Game.YSIZE);
			this.x = rnd.nextInt(Game.XSIZE);
		} while (!Game.map[this.y][this.x].equals("."));
	}
	
	public int getY() { return this.y; }
	public int getX() { return this.x; }
	public void setY(int y) { this.y = y; }
	public void setX(int x) { this.x = x; }
	

}
