package v3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogrotationExample {
	private static final String LOG_FILE_NAME = "app.log";
	private static final long MAX_LOG_FILE_SIZE = 1024 * 1024; // 1MB
	
	public static void log(String message) throws IOException {
		File logFile = new File(LOG_FILE_NAME);
		if (logFile.length() >= MAX_LOG_FILE_SIZE) {
			rotateLogFile(logFile);
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
			writer.write(message);
			writer.newLine();
		}
	}
	
	private static void rotateLogFile(File logFile) {
		File oldLogFile = new File(LOG_FILE_NAME + ".old");
		if (oldLogFile.exists()) {
			oldLogFile.delete();
		}
		logFile.renameTo(oldLogFile);
	}
	
	public static void main(String[] args) {
		try {
			log("アプリケーションが開始されました。");
			// other message
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
