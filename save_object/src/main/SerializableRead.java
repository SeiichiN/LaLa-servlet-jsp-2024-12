package main;

public class SerializableRead {

	public static void main(String[] args) {
		Hero hero = (Hero) SerializableRW.readObj("hero.obj");
		Matango m = (Matango) SerializableRW.readObj("matango.obj");
		hero.attack(m);
		m.attack(hero);
		System.out.println("m.hp:" + m.getHp());
	}
	
}
