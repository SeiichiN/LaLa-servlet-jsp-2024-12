package main;

import java.io.Serializable;

public class Matango implements Serializable {
	private char suffix;
	private int hp;
	public Matango(char suffix) {
		this.suffix = suffix;
	}
	public void attack(Hero h) {
		System.out.println(this.getSuffix() + "は" + h.getName() + "を攻撃した！");
		h.setHp(h.getHp() - 5);
		System.out.println(h.getName() + "に５ポイントのダメージを与えた！");
	}
	
	public void run() {
		System.out.println(this.getSuffix() + "は逃げ出した！");
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
