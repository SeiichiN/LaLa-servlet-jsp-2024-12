package model;

import java.util.List;

import dao.PersonDAO;

public class FindAllLogic {
	public List<Person> execute() {
		PersonDAO dao = new PersonDAO();
		return dao.findAll();
	}
}
