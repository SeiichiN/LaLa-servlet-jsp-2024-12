package game;

public abstract class Monster extends GameLocation  {
	private String type;
	private int hp;
	SetSelfOnMap setSelfObj;
	
	public Monster() {}
	public Monster(String type, SetSelfOnMap setSelfObj) {
		this.type = type;
		this.hp = 100;
		this.setSelfObj = setSelfObj;
		setLocation();
		setSelfObj.setSelfOnMap(this, this.getType());
	}

	public abstract void attack(Player p);
	
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
