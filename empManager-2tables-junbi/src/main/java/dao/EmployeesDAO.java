package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import bean.Dept;
import bean.Employee;
import bean.EmployeeForm;

public class EmployeesDAO {
	private final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/two_tables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private final String SQL_FINDALL =
			"SELECT " +
			"  e.id AS empId, " +
			"  e.name AS empName, " +
			"  e.gender AS gender, " +
			"  e.birthday AS birthday, " +
			"  d.id AS deptId, " +
			"  d.name AS deptName " +
			" FROM EMPLOYEES e " +
			"   INNER JOIN departments d " +
			"   ON e.dept_id = d.id " +
			" ORDER BY e.id ASC	";

	private final String SQL_FINDBYID = 
			"""
			SELECT
			  e.id AS empId,
			  e.name AS empName,
			  e.gender AS gender,
			  e.birthday AS birthday,
			  d.id AS deptId,
			  d.name AS deptName
			FROM EMPLOYEES e
			  INNER JOIN departments d
			  ON e.dept_id = d.id
			WHERE e.id = ?
			""";

	private final String SQL_FINDBYNAME = 
			"""
			SELECT
			  e.id AS empId,
			  e.name AS empName,
			  e.gender AS gender,
			  e.birthday AS birthday,
			  d.id AS deptId,
			  d.name AS deptName
			FROM EMPLOYEES e
			  INNER JOIN departments d
			  ON e.dept_id = d.id
			WHERE e.name like ?
			""";
	
	private final String SQL_FINDBY_DEPTID = 
			"""
			SELECT
			  e.id AS empId,
			  e.name AS empName,
			  e.gender AS gender,
			  e.birthday AS birthday,
			  d.id AS deptId,
			  d.name AS deptName
			FROM EMPLOYEES e
			  INNER JOIN departments d
			  ON e.dept_id = d.id
			WHERE d.id = ?
			""";

	
	private final String SQL_CREATE = 
			"""
			INSERT INTO employees
			  (name, gender, birthday, dept_id)
			VALUES (?, ?, ?, ?)
			""";

	private final String SQL_UPDATE = 
			"UPDATE employees SET name = ?, gender = ?, birthday = ?, dept_id = ? " +
			" WHERE id = ?";
	
	private final String SQL_REMOVE = "DELETE FROM employees WHERE id = ?";
	
	private void getDriver() {
		// jdbcドライバ
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			  ("JDBCドライバーを読み込めません");
		}		
	}
	
	private int getAgeFromBirthday(Date birthday) {
		LocalDate birthDate = birthday.toLocalDate(); // LocalDate 型に変換
		LocalDate today = LocalDate.now();
		int age = Period.between(birthDate, today).getYears(); // 年齢計算
		return age;
	}
	
	private Employee getEmployeeFromRs(ResultSet rs) throws SQLException {
		int empId = rs.getInt("empId");
		String empName = rs.getString("empName");
		int gender = rs.getInt("gender");
		Date _birthday = rs.getDate("birthday");
		int age = getAgeFromBirthday(_birthday);
		String birthday = _birthday.toString().replace("-", "/");
		int deptId = rs.getInt("deptId");
		String deptName = rs.getString("deptName");
		Dept dept = new Dept(deptId, deptName);
		Employee employee = new Employee(empId, empName, gender, age, birthday, dept);
		return employee;
	}
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		getDriver();
		// db接続
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FINDALL);
			// 実行
			ResultSet rs = pStmt.executeQuery();
			// 表示
			while (rs.next()) {
				Employee employee = getEmployeeFromRs(rs);
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return empList;
	}

	public Employee findById(int empId) {
		Employee emp = null;
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FINDBYID);
			pStmt.setInt(1, empId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				emp = getEmployeeFromRs(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}
	
	public List<Employee> findByName(String _name) {
		List<Employee> empList = new ArrayList<>();
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FINDBYNAME);
			pStmt.setString(1, "%" + _name + "%");
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Employee emp = getEmployeeFromRs(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}

	public List<Employee> findByDeptId(int deptId) {
		List<Employee> empList = new ArrayList<>();
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FINDBY_DEPTID);
			pStmt.setInt(1, deptId);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Employee emp = getEmployeeFromRs(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}

	public boolean create(EmployeeForm empForm) {
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_CREATE)) {
				pStmt.setString(1, empForm.getName());
				pStmt.setInt(2, empForm.getGender());
				String birthday = empForm.getBirthday().replaceAll("/", "-");
				pStmt.setString(3, birthday);
				pStmt.setInt(4, empForm.getDeptId());
				int result = pStmt.executeUpdate();
				if (result != 1) {
					conn.rollback();
					return false;
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(EmployeeForm empForm) {
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_UPDATE)) {
				pStmt.setString(1, empForm.getName());
				pStmt.setInt(2, empForm.getGender());
				String birthday = empForm.getBirthday().replaceAll("/", "-");
				pStmt.setString(3, birthday);
				pStmt.setInt(4, empForm.getDeptId());
				pStmt.setInt(5, empForm.getId());
				int result = pStmt.executeUpdate();
				if (result != 1) {
					conn.rollback();
					return false;
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removeById(String id) {
		getDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_REMOVE)) {
				pStmt.setString(1, id);
				int result = pStmt.executeUpdate();
				if (result != 1) {
					conn.rollback();
					return false;
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
