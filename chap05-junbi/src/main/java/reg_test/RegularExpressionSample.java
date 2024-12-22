package reg_test;

import java.util.regex.Pattern;

public class RegularExpressionSample {

	public static void main(String[] args) {
		String str = "java";
		Pattern pattern = Pattern.compile("^[0-9A-Za-z]{4}$");
		if (pattern.matcher(str).matches()) {
			System.out.println("一致しました。");
		} else {
			System.out.println("一致しません。");
		}

	}

}
