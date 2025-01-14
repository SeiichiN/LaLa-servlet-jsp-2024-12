package main;

import model.Person;
import model.PostPersonLogic;

public class PostPersonLogicTest {
	public static void main(String[] args) {
		Person p = new Person(0, "山本 一郎", "1999-09-09");
		PostPersonLogic logic = new PostPersonLogic();
		if (logic.execute(p)) {
			System.out.println("OK");
		} else {
			System.out.println("BAD");
		}
	}
}