package test3;

import model.Employee;
import model.RegisterEmpLogic;

public class RegisterEmpLogicTest {

	public static void main(String[] args) {
		
		RegisterEmpLogic logic = new RegisterEmpLogic();
		Employee emp = new Employee("EMP003", "菅原 拓真", 34);
		boolean result = logic.execute(emp);
		if (result) {
			System.out.println("登録成功");
		} else {
			System.out.println("登録失敗");
		}
	}

}
