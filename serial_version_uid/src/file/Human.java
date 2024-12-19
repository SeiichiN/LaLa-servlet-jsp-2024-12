package file;

import java.io.Serializable;

public class Human implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}
