package v1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogExample {

	public static void main(String[] args) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("logfile.txt", true))) {
			writer.write("INFO: アプリケーションが正常に起動しました。");
			writer.newLine();
			writer.write("ERROR: データベース接続に失敗しました。");
			writer.newLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
