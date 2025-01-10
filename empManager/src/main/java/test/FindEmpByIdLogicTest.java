package test;

import model.Employee;
import model.FindEmpByIdLogic;

public class FindEmpByIdLogicTest {

	public static void main(String[] args) {
		String id = "EMP003";
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee employee = logic.execute(id);
		System.out.println(employee);
	}

}
