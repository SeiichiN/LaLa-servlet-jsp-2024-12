package test3;

import servlet.util.ZenHanUtil;

public class ZenHanUtilTest {

	public static void main(String[] args) {
		String str = "えＭＰ００１";
		String str2 = ZenHanUtil.execute(str);
		System.out.println(str + " -> " + str2);
		

	}

}
