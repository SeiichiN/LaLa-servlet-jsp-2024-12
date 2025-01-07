package test;

import java.util.List;

import model.GetMutterListLogic;
import model.Mutter;

public class FindAllTest {

	public static void main(String[] args) {
		GetMutterListLogic logic = new GetMutterListLogic();
		List<Mutter> mutterList = logic.execute();
		for (Mutter m : mutterList) {
			System.out.println(m);
		}
	}

}
