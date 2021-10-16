package com.revature.DAO;



import java.util.List;

import com.revature.Models.EmployeeRequest;

public interface RequestDAO {
	
    
	
	public List<EmployeeRequest> select();
	public void delete();
	
	//public void update();

	//void insert(ReimbursementRequest r);
	void iselect();
	//void insert();
	void insert(EmployeeRequest e);
	//EmployeeRequest selectByEmail(String email);
	//EmployeeRequest selectByEmail();
	//EmployeeRequest selectByEmail(String email);
	//List<EmployeeRequest> selectByEmail();
	//EmployeeRequest selectByEmail(EmployeeRequest eq);
	//EmployeeRequest selectByEmail(String email);
	//EmployeeRequest selectById();
	EmployeeRequest selectById(int id);
	void update(EmployeeRequest employeeRequest);
	

}
