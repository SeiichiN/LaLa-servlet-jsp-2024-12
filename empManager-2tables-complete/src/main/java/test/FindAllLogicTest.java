package test;

import java.util.List;

import bean.Employee;
import model.FindAllLogic;

public class FindAllLogicTest {

	public static void main(String[] args) {
		FindAllLogic logic = new FindAllLogic();
		List<Employee> empList = logic.execute();
		for (Employee emp : empList) {
			System.out.println(emp);
		}

	}

}
