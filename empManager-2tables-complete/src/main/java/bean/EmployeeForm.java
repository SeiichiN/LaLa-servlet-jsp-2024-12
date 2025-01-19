package bean;

import java.io.Serializable;

public class EmployeeForm implements Serializable {
	private int id;
	private String name;
	private int gender;
	private String birthday;
	private int deptId;
	
	public EmployeeForm() {}
	
	// create用
	public EmployeeForm(String name, int gender, String birthday, int deptId) {
		this(0, name, gender, birthday, deptId);
	}
	
	// update用
	public EmployeeForm(int id, String name, int gender, String birthday, int deptId) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "EmployeeForm [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", deptId=" + deptId
				+ "]";
	}
	
}
