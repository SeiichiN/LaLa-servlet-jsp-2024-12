package test2;

import model.CreateEmployeeLogic;
import model.Employee;

public class CreateEmpTest {

	public static void main(String[] args) {
		Employee emp = new Employee("EMP004", "木下藤吉郎", 34);
		CreateEmployeeLogic logic = new CreateEmployeeLogic();
		if (logic.execute(emp)) {
			System.out.println("登録しました");
		} else {
			System.out.println("失敗しました");
		}
	}

}
