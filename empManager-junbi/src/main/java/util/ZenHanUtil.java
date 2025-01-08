package util;

public class ZenHanUtil {
	
	public static String toHankaku(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			int c = (int) sb.charAt(i);
			if ((c >= 0xFF10 && c <= 0xFF19) || 
				(c >= 0xFF21 && c <= 0xFF3A) || 
				(c >= 0xFF41 && c <= 0xFF5A)) {
				sb.setCharAt(i, (char) (c - 0xFEE0));
			}
		}
		str = sb.toString();
		return str;
	}
}
