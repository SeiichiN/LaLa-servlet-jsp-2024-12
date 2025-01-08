package test;

import util.ZenHanUtil;

public class ToHankekuTest {

	public static void main(String[] args) {
		String str = "あいうＥＭＰ";
		String str2 = ZenHanUtil.toHankaku(str);
		if (str != null && str2 != null) {
			System.out.println(str + " -> " + str2);
		}
		System.out.println("----------");
	}

}
