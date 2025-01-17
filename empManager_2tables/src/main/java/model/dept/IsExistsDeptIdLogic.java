package model.dept;

import dao.DepartmentsDAO;

public class IsExistsDeptIdLogic {
	public boolean execture(int deptId) {
		DepartmentsDAO dao = new DepartmentsDAO();
		return dao.isExistsId(deptId);
	}
}
