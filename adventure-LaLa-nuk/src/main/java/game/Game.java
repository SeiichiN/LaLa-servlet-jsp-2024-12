package game;

import java.io.Serializable;
import java.util.Scanner;

public class Game implements Serializable {
	private int ysize = 5;
	private int xsize = 5;
	private String[][] map = {
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."},
			{".", ".", "#", "#", "."},
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."}
	}; 
	
	public static void opening() {
		// p.68 テキストブロック
		String str = 
				"""
				+----------------------+
				| Adventure Game       |
				|                      |
				|  by Seiichi Nukayama |
				+----------------------+
				""";
		System.out.println(str);
	}
	
	public void printMap(Player p) {
		for (int y = 0; y < ysize; y++) {
			System.out.print("| ");
			for (int x = 0; x < xsize; x++) {
				if (y == p.getY() && x == p.getX()) {
					System.out.print("*");
				} else {
					System.out.print(map[y][x].charAt(0));
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}
	
	public void buttle(Player p, Monster m) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			if (p.getHp() <= 0 || m.getHp() <= 0) { break; }
			System.out.print("A:戦う R:逃げる > ");
			String s = scan.nextLine();
			switch (s) {
				case "r" -> { return; }
				case "a" -> {
					p.attack(m);
					m.attack(p);
					System.out.print(p.getName() + " HP:" + p.getHp() + "  ");
					System.out.println(m.getType() + " HP:" + m.getHp());
				}
			}
		}
		if (m.getHp() <= 0) {
			map[m.getY()][m.getX()] = ".";
 		}
	}

	public int getYsize() {
		return ysize;
	}

	public int getXsize() {
		return xsize;
	}

	public String[][] getMap() {
		return map;
	}
}
