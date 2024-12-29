package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends GameLocation 
                              implements SetSelfOnMap {
	private String type;
	private String jaType;
	private int hp;
	private AttackStrategy strategy;
	
	public Monster(String type, AttackStrategy strategy) {
		this.type = type;
		this.jaType = Game.getJa(type);
		this.hp = 100;
		this.strategy = strategy;
		setLocation();
		setSelfOnMap();
	}
	public String getJaType() {
		return jaType;
	}
	public void setSelfOnMap() {
		Game.map[this.getY()][this.getX()] = this.type;
	}
	
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		if (this.getHp() <= 0) {
			Game.map[this.getY()][this.getX()] = ".";
			return null; 
		}
		msgList.add(this.getJaType() + "は" + strategy.uniqueAttack());
		int ap = (int)Math.floor(Math.random() * (strategy.getMAXAP() + 1));
		p.setHp(p.getHp() - ap);
		msgList.add(p.getName() + "に" + ap + "ポイントのダメージ");
		if (p.getHp() <= 0) {
			msgList.add(p.getName() + "を倒した。");
		}
		return msgList;
	}
	
	
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
