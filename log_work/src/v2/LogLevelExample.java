package v2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogLevelExample {
	enum LogLevel {
		DEBUG, INFO, WARN, ERROR, FATAL
	}

	public static void log(String message, LogLevel level) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("logfile.txt", true))) {
			writer.write(level + ": " + message);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		log("アプリケーションが開始されました。", LogLevel.INFO);
		log("デバッグモードが有効になってます。", LogLevel.DEBUG);
		log("データベース接続に失敗しました。" , LogLevel.ERROR);

	}

}
