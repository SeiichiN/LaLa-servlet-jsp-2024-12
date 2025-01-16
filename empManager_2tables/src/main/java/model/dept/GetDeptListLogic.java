package model.dept;

import java.util.List;

import bean.Dept;
import dao.DepartmentsDAO;

public class GetDeptListLogic {
	public List<Dept> execute() {
		DepartmentsDAO dao = new DepartmentsDAO();
		return dao.findAll();
	}
}
