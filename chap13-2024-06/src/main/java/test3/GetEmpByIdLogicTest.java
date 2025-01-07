package test3;

import model.Employee;
import model.GetEmpByIdLogic;

public class GetEmpByIdLogicTest {

	public static void main(String[] args) {
		GetEmpByIdLogic logic = new GetEmpByIdLogic();
		String id = "EMP001";
		Employee emp = logic.execute(id);
		System.out.println(emp);
		if (emp != null) {
			System.out.println("取得成功");
		} else {
			System.out.println("取得失敗");
		}

	}

}
