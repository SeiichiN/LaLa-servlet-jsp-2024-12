package test;

import model.RemoveEmpLogic;

public class RemoveEmpLogicTest {

	public static void main(String[] args) {
		RemoveEmpLogic logic = new RemoveEmpLogic();
		if (logic.execute("EMP004")) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

	}

}
