package test;

import java.util.List;

import bean.Dept;
import model.dept.GetDeptListLogic;

public class GetDeptListLogicTest {

	public static void main(String[] args) {
		GetDeptListLogic logic = new GetDeptListLogic();
		List<Dept> deptList = logic.execute();
		for (Dept d : deptList) {
			System.out.println(d);
		}

	}

}
