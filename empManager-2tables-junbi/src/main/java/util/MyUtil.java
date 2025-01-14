package util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class MyUtil {
	public static int myParseInt(String numTxt) {
		int num = 0;
		try {
			num = Integer.parseInt(numTxt);
		} catch (NumberFormatException e) {
			num = -1;
		}
		return num;
	}
	
	public static boolean isDate(String dateTxt) {
		String[] data = dateTxt.split("/");
		String year = data[0];
		String month = "0" + data[1];
		month = month.substring(month.length() - 2);
		String day = "0" + data[2];
		day = day.substring(day.length() - 2);
		dateTxt = year + "/" + month + "/" + day;

		String pattern = "uuuu/MM/dd";
		DateTimeFormatter fmt = 
				DateTimeFormatter.ofPattern(pattern)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dateTxt, fmt);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	public static String date2str(Date date) {
		return date.toString();
	}
}
