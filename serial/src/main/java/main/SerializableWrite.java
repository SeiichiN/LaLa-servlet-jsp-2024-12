package main;

import beans.Hero;
import beans.Matango;

public class SerializableWrite {

	public static void main(String[] args) {
		Hero hero = new Hero("アサカ");
		SerializableRW.saveObj("hero.obj", hero);
		
		Matango m = new Matango('B');
		m.setHp(50);
		SerializableRW.saveObj("matango.obj", m);
	}

}
