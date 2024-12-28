package game;

import java.util.Scanner;

public class Game {
	public static final int YSIZE = 5;
	public static final int XSIZE = 5;
	public static String[][] map = {
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."},
			{".", ".", "#", "#", "."},
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."}
	}; 
	
	public static void initMap() {
		map = new String[][]{
				{".", ".", ".", ".", "."},
				{".", ".", ".", ".", "."},
				{".", ".", "#", "#", "."},
				{".", ".", ".", ".", "."},
				{".", ".", ".", ".", "."}
		};		
	}
	
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
	
	public static void printMap(Player p) {
		for (int y = 0; y < YSIZE; y++) {
			System.out.print("| ");
			for (int x = 0; x < XSIZE; x++) {
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
	
	public static void buttle(Player p, Monster m) {
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
}
