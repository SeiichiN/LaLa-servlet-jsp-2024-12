package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	private final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private void getDriver() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバーが読み込めません");
		}
	}
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		getDriver();
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, age FROM employees" +
				         " ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id, name, age);
				empList.add(employee)
;			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public boolean remove (String id) {
		getDriver();
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM employees WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();   // 1 -- 削除成功
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * idが存在するかどうかを調べる
	 * @param id
	 * @return true 存在する<br>
	 *         false 存在しない
	 */
	public boolean isExistsId(String id) {
		getDriver();
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id FROM employees WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean create(Employee emp) {
		getDriver();
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO employees (id, name, age) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
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
	
	public boolean update(Employee emp) {
		getDriver();
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = 
				"UPDATE employees SET name = ?, age = ?" +
			    " WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, emp.getAge());
			pStmt.setString(3, emp.getId());
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
	
	public Employee findById(String _id) {
		getDriver();
		Employee emp = null;
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = 
				"SELECT id, name, age FROM employees WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, _id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				emp = new Employee(id, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}
	
	public List<Employee> findByName(String _name) {
		getDriver();
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, age FROM employees" +
				         " WHERE name LIKE ? ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + _name + "%");
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee emp = new Employee(id, name, age);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
}
