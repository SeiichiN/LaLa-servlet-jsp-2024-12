package game;

import java.util.List;

public abstract class Monster extends GameLocation 
                              implements SetSelfOnMap {
	private String type;
	private int hp;
	
	public Monster(String type) {
		this.type = type;
		this.hp = 100;
		setLocation();
		setSelfOnMap();
	}
	public void setSelfOnMap() {
		Game.map[this.getY()][this.getX()] = this.type;
	}
	
	public abstract List<String> attack(Player p);
	
	public String getType() {
		return this.type;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
}
