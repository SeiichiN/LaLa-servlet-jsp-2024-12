package main;

import java.io.Serializable;

public class Hero implements Serializable {

	private String name;
	private int hp;

	public Hero(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void attack(Matango m) {
		System.out.println(this.getName() + "は" + m.getSuffix() + "を攻撃した！");
		m.setHp(m.getHp() - 7);
		System.out.println(m.getSuffix() + "に7ポイントのダメージを与えた！");
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
