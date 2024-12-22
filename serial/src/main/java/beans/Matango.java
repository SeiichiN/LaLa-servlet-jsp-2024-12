package beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Matango implements Serializable {
	private char suffix;
	private int hp;
	public Matango(char suffix) {
		this.suffix = suffix;
	}
	public List<String> attack(Hero h) {
		List<String> msgList = new ArrayList<>();
		msgList.add(this.getSuffix() + "は" + h.getName() + "を攻撃した！");
		h.setHp(h.getHp() - 5);
		msgList.add(h.getName() + "に５ポイントのダメージを与えた！");
		return msgList;
	}
	
	public List<String> run() {
		List<String> msgList = new ArrayList<>();
		msgList.add(this.getSuffix() + "は逃げ出した！");
		return msgList;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public char getSuffix() {
		return suffix;
	}
	
}
