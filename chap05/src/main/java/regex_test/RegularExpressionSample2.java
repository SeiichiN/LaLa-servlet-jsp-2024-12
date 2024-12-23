package regex_test;

public class RegularExpressionSample2 {

	public static void main(String[] args) {
		String str = "java";

		if (str.matches("^[0-9a-zA-Z]{4}$")) {
			System.out.println("一致しました");
		} else {
			System.out.println("一致しません");
		}

	}

}
