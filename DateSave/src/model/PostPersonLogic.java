package model;

import dao.PersonDAO;

public class PostPersonLogic {
	public boolean execute(Person person) {
		PersonDAO dao = new PersonDAO();
		return dao.create(person);
	}
}
