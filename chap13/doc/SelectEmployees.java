package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployees {

	public static void main(String[] args) {
		// jdbcドライバ
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			  ("JDBCドライバーを読み込めません");
		}
		// db接続
		try (Connection conn = DriverManager.getConnection
				("jdbc:h2:tcp://localhost/~/example", "sa", "")) {
			String sql = "SELECT id, name, age FROM employees";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// 実行
			ResultSet rs = pStmt.executeQuery();
			// 表示
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println("ID:" + id);
				System.out.println("名前:" + name);
				System.out.println("年齢:" + age);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
