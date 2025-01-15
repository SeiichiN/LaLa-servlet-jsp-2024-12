package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import bean.Dept;
import bean.Employee;

public class EmployeesDAO {
	private final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/two_tables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private final String SQL_FINDALL =
			"""
			SELECT
			  e.id       AS empId,
			  e.name     AS empName,
			  e.gender   AS gender,
			  e.birthday AS birghday,
			  d.id       AS deptId,
			  d.name     AS deptName
			FROM employees e
			  INNER JOIN departments d
			  ON e.dept_id = d.id
			ORDER BY e.id ASC;
			""";

	
	private void getDriver() {
		// jdbcドライバ
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			  ("JDBCドライバーを読み込めません");
		}		
	}
	
	private int getAgeFromBirthday(LocalDate birthDate) {
		LocalDate today = LocalDate.now();
		return Period.between(birthDate, today).getYears();
	}
	
	private String date2str(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
	
	private Employee getEmpFromRs(ResultSet rs) throws SQLException {
		int empId = rs.getInt("empId");
		String empName = rs.getString("empName");
		int gender = rs.getInt("gender");
		LocalDate birthDate = rs.getDate("birthday").toLocalDate();
		String birthday = date2str(birthDate);
		int age = getAgeFromBirthday(birthDate);
		int deptId = rs.getInt("deptId");
		String deptName = rs.getString("deptName");
		Dept dept = new Dept(deptId, deptName);
		Employee emp = new Employee(empId, empName, gender, age, birthday, dept);
		return emp;
	}
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		getDriver();
		// db接続
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FINDALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Employee employee = getEmpFromRs(rs);
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return empList;
	}	
}
