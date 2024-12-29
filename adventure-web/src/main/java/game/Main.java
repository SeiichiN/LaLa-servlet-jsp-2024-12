package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	   // Game.opening();
		GoblinAttackStrategy goblinStrategy = new GoblinAttackStrategy();
		Goblin g = new Goblin("goblin", goblinStrategy);
		DragonAttackStrategy dragonStrategy = new DragonAttackStrategy();
		Dragon d = new Dragon("dragon", dragonStrategy);
		Potion po = new Potion("potion");
		Ether e = new Ether("ether");
		Player p = new Player("太郎");
		// p.look();

		outHere:
		while (true) {
			if (p.getHp() <= 0) {
				System.out.println(p.getName() + "は、倒れてしまった。");
				break; 
			}
			System.out.print("WENS:移動 I:持物 Q:終了 > ");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			switch (s) {
				case "q" -> { break outHere; }
				case "w","e","n","s" -> {
					p.move(s); 
					// p.look(); 
				}
				case "i" -> { p.printItemList(); }
				case "p" -> { /* Game.printMap(p); */ }
			}
			String thing = Game.map[p.getY()][p.getX()];
			switch (thing) {
			case "goblin" -> {	/* Game.buttle(p, g); */ }
			case "dragon" -> { /* Game.buttle(p, d); */ }
			case "potion" -> { p.take(po); }
			case "ether" -> { p.take(e); }
			}
		}
		System.out.println("GAME OVER");

	}

}
