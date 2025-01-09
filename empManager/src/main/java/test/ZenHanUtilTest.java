package test;

public class ZenHanUtilTest {

	public static void main(String[] args) {
		String str = "えｍｐ００５";
		ZenHanUtil util = new ZenHanUtil();
		String str2 = util.toHankaku(str);
		System.out.println(str + " -> " + str2);

	}

}
