package bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private int id;
	private String name;
	private int gender;
	private int age;
	private String birthday;
	private Dept dept;

	public Employee() {
	}

	public Employee(int id, String name, int gender, int age, String birthday, Dept dept) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.dept = dept;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", birthday="
				+ birthday + ", dept=" + dept + "]";
	}

}
