package reg_test;

import java.util.regex.Pattern;

public class RegularExpressionSample2 {

	public static void main(String[] args) {
		String str = "java";
		if (str.matches("^[0-9A-Za-z]{4}$")) {
			System.out.println("一致しました。");
		} else {
			System.out.println("一致しません。");
		}

	}

}
