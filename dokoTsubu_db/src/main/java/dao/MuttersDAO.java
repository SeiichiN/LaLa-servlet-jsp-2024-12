package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MuttersDAO {
	private final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/dokoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private void getDriver() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			  ("JDBCドライバーを読み込めません");
		}
	}
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		
		getDriver();
		
		try (Connection conn = 
				DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);) {
			String sql = "select id, name, text from mutters order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	
	public boolean create(Mutter mutter) {
		getDriver();
		
		try (Connection conn = 
				DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO MUTTERS (name, text) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
