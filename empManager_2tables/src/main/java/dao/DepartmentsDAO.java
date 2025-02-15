package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Dept;

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
	// true -- そのdeptIdは存在する
	public boolean isExistsId(int deptId) {
		getDriver();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "Select count(*) AS num FROM departments " + 
		                  " WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, deptId);
			ResultSet rs = pStmt.executeQuery();
			int num = 0;
			if (rs.next()) {
				num = rs.getInt("num");
			}
			if (num == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		getDriver();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name FROM departments ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
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
	
	
}
