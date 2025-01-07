package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeesDAO {
	private final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		// jdbcドライバ
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			  ("JDBCドライバーを読み込めません");
		}		
		// db接続
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, age FROM employees";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// 実行
			ResultSet rs = pStmt.executeQuery();
			// 表示
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return empList;
	}
}
