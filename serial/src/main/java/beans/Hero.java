package beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hero implements Serializable {

	private String name;
	private int hp;

	public Hero(String name) {
		this.name = name;
		this.hp = 100;
	}
	public List<String> attack(Matango m) {
		List<String> msgList = new ArrayList<>();
		msgList.add(this.getName() + "は" + m.getSuffix() + "を攻撃した！");
		m.setHp(m.getHp() - 5);
		msgList.add(m.getSuffix() + "に５ポイントのダメージを与えた！");
		return msgList;
	}
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
}
