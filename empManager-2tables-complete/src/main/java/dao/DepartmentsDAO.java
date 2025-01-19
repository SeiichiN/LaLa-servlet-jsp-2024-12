package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Dept;
import bean.Employee;

public class DepartmentsDAO {
	private final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/two_tables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private void getDriver() {
		// jdbcドライバ
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			  ("JDBCドライバーを読み込めません");
		}		
	}
	
	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		getDriver();
		// db接続
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name FROM departments";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// 実行
			ResultSet rs = pStmt.executeQuery();
			// 表示
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Dept dept = new Dept(id, name);
				deptList.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return deptList;
	}

	public Dept findById(int id) {
		Dept dept = null;
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT name FROM departments WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				dept = new Dept(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dept;
	}
	
	public boolean isExistsId(int id) {
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT count(*) AS num FROM departments WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("num");
			}
			if (count == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}
}
