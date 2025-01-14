package test;

import model.Employee;
import model.UpdateEmpLogic;

public class UpdateEmpLogicTest {

	public static void main(String[] args) {
		Employee emp = new Employee("EMP004", "金 太郎", 23);
		UpdateEmpLogic logic = new UpdateEmpLogic();
		if (logic.execute(emp)) {
			System.out.println("OK");
		} else {
			System.out.println("NO GooD!");
		}

	}

}
