package test;

import model.Mutter;
import model.PostMutterLogic;

public class CteateTest {

	public static void main(String[] args) {
		Mutter mutter = new Mutter("菅原", "僕は明日は仕事だ～");
		PostMutterLogic logic = new PostMutterLogic();
		if (logic.execute(mutter)) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
	}

}
