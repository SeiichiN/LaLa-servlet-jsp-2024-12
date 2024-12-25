package v5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
	private static final Logger logger = LogManager.getLogger(Log4jExample.class);

	public static void main(String[] args) {
		logger.debug("DEBUG: デバッグモードが有効です。");
		logger.info("INFO: アプリケーションが開始されました。");
		logger.warn("WARN: 不正な入力が検出されました。");
		logger.error("ERROR: サーバーとの接続に失敗しました。");

	}

}
