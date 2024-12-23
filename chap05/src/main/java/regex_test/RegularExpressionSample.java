package regex_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionSample {

	public static void main(String[] args) {
		String str = "java";
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z]{4}$");
		Matcher m = pattern.matcher(str);
		if (m.matches()) {
			System.out.println("一致しました");
		} else {
			System.out.println("一致しません");
		}

	}

}
