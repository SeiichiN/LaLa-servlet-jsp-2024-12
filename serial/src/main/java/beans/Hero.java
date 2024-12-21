package beans;

import java.io.Serializable;

public class Hero implements Serializable {
	private String name;
	private int age;

	public Hero(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
