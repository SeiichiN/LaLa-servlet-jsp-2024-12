package test;

import model.IsDuplicateLogic;

public class IsDuplicateLogicTest {

	public static void main(String[] args) {
		String id = "EMP006";
		IsDuplicateLogic logic = new IsDuplicateLogic();
		if (logic.execute(id)) {
			System.out.println("そのIDは使われています");
		} else {
			System.out.println("そのIDは使用可能です");
		}

	}

}
