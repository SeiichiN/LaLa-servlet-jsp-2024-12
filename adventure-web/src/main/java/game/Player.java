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
		itemList.add(item);
		Game.map[item.getY()][item.getX()] = ".";
	}
	
	public List<Item> getItemList() {
		return itemList;
	}

	public List<String> use(String itemType) {
		List<String> msgList = new ArrayList<>();
		Item item = null;
		for (Item i : itemList) {
			if (i.getType().equals(itemType)) {
				item = i;
			}
		}
		if (item instanceof Potion p) {
			msgList = use(p);
		} else if (item instanceof Ether e) {
			msgList = use(e);
		}
		itemList.remove(item);
		return msgList;
	}
	
	public List<String> use(Ether e) {
		List<String> msgList = new ArrayList<>();
		msgList.add("エーテルを使ったが、" + this.getName() + 
				"は魔法が使えないので、効果はなかった。");
		return msgList;
	}
	
	public List<String> use(Potion p) {
		List<String> msgList = new ArrayList<>();
		this.setHp(p.getRp());
		msgList.add(this.getName() + "はポーションを使った！");
		msgList.add(this.getName() + "のHPが" + this.getHp() + "に回復した");
		return msgList;
	}
	
	public void printItemList() {
		System.out.print("持ち物:");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print(" (" + i + ")" + itemList.get(i).getType());
		}
		System.out.println();
		System.out.print("どれを使いますか？ > ");
		
	}
	
	public List<String> attack(Monster m) {
		List<String> msgList = new ArrayList<>();
		if (this.hp <= 0) { return null; }
		msgList.add(this.getName() + "は剣で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 31);
		m.setHp(m.getHp() - ap);
		msgList.add(m.getType() + "に" + ap + "ポイントのダメージ");
		if (m.getHp() <= 0) {
			msgList.add(m.getType() + "を倒した。");
		}
		return msgList;
	}
	
	public List<String> run() {
		List<String> msgList = new ArrayList<>();
		msgList.add(this.getName() + "は、逃げ出した！");
		return msgList;
	}
	
	public void look() {
		System.out.print("[" + getY() + ":" + getX() + "] ");
		System.out.println(Game.map[getY()][getX()]);
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
		case "a" -> { moveLeft(); }
		case "d" -> { moveRight(); }
		case "w" -> { moveUp(); }
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
