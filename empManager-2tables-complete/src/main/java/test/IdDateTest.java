package test;

import util.MyUtil;

public class IdDateTest {

	public static void main(String[] args) {
		String dateTxt = "1999/9/9";
		if (MyUtil.isDate(dateTxt)) {
			System.out.println("正しい日付です");
		} else {
			System.out.println("不正な日付です");
		}
	}

}
