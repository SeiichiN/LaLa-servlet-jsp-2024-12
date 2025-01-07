package model;

import dao.EmployeeDAO;
import model.interf.EmployeeLogic;

public class CreateEmployeeLogic 
                  implements EmployeeLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.create(emp);
	}
}
