package model.dept;

import dao.DepartmentsDAO;

public class IsExistsIdLogic {
	public boolean execute(int id) {
		DepartmentsDAO dao = new DepartmentsDAO();
		if (dao.isExistsId(id)) {
			return true;
		}
		return false;
	}
}
