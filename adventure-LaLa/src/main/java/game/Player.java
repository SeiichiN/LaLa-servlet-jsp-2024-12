package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	private String name;
	private int hp;
	private List<Item> itemList = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
		setLocation();
	}
	
	public void take(Item item) {
		System.out.print("取りますか？ (y/n) > ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine().toLowerCase();
		if (s.equals("y")) {
			itemList.add(item);
			Game.map[item.getY()][item.getX()] = ".";
		}
	}
	
	public void use(Potion p) {
		this.setHp(p.getRp());
		System.out.println(this.getName() + "のHPが" + this.getHp() + "に回復した");
	}
	
	public void printItemList() {
		System.out.print("持ち物:");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print(" (" + i + ")" + itemList.get(i).getType());
		}
		System.out.println();
		System.out.print("どれを使いますか？ > ");
		
	}
	
	public void attack(Monster m) {
		if (this.hp <= 0) { return; }
		System.out.println(this.getName() + "は剣で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 31);
		m.setHp(m.getHp() - ap);
		System.out.println(m.getType() + "に" + ap + "ポイントのダメージ");
		if (m.getHp() <= 0) {
			System.out.println(m.getType() + "を倒した。");
		}		
	}
	
	public String look() {
		return Game.map[getY()][getX()];
	}
	
	public String toString() {
		return name + " HP:" + hp;
	}
	
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void move(String dir) {
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(); }
		}
	}
	private void moveLeft() {
		this.setX(this.getX() - 1);
		if (this.getX() < 0) { this.setX(0);	}
	}
	private void moveRight() {
		this.setX(this.getX() + 1);
		if (this.getX() >= Game.XSIZE) { this.setX(Game.XSIZE - 1);	}
	}
	private void moveUp() {
		this.setY(this.getY() - 1);
		if (this.getY() < 0) { this.setY(0);	}
	}
	private void moveDown() {
		this.setY(this.getY() + 1);
		if (this.getY() >= Game.YSIZE) { this.setY(Game.YSIZE - 1);	}
	}
}
