package test;

import java.util.List;

import bean.Employee;
import model.FindAllLogic;
import model.FindEmpByIdLogic;

public class FindEmpByIdLogicTest {

	public static void main(String[] args) {
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee emp = logic.execute(1);
		System.out.println(emp);

	}

}
