package main;

import java.util.List;

import model.FindAllLogic;
import model.Person;

public class main {

	public static void main(String[] args) {
		FindAllLogic logic = new FindAllLogic();
		List<Person> personList = logic.execute();
		for (Person p : personList) {
			System.out.println(p);
		}

	}

}
