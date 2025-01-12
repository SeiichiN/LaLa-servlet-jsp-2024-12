package model.dept;

import java.util.List;

import bean.Dept;
import dao.DepartmentsDAO;

public class FindDeptListLogic {
	public List<Dept> execute() {
		DepartmentsDAO dao = new DepartmentsDAO();
		List<Dept> deptList = dao.findAll();
		return deptList;
	}
	
}
