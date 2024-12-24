package v4;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerExample {
	private static final Logger logger = 
			Logger.getLogger(LoggerExample.class.getName()); 

	public static void main(String[] args) {
		try {
			FileHandler fileHandler = new FileHandler("app.log", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			
			logger.setLevel(Level.ALL);
			logger.info("INFO: アプリケーションが開始されました。");
			logger.warning("WARNING: データベース接続に時間がかかっています。");
			logger.severe("ERROR: データベース接続に失敗しました。");
		} catch (IOException e) {
			logger.severe("ファイルハンドラーの初期化に失敗しました。" + e.getMessage());
		}
	}

}
