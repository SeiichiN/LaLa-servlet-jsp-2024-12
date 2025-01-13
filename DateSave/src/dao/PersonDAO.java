package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/date_test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private void getDriver() {
	
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("DB接続エラー");
		}
	}
	
	public List<Person> findAll() {
		List<Person> personList = new ArrayList<>();
		getDriver();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, birthday FROM person ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				Person person = new Person(id, name, birthday);
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}
	
	private Date toDate(String dateTxt) {
		
	}
}
