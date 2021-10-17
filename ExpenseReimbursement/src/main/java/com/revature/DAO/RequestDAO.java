package com.revature.DAO;



import java.util.List;

import com.revature.Models.EmployeeRequest;

public interface RequestDAO {
	
    
	
	public List<EmployeeRequest> select();
	public void delete();
	
	
	void iselect();
	
	void insert(EmployeeRequest e);
	
	void update(EmployeeRequest employeeRequest);
	EmployeeRequest selectByStatus(String status);
	EmployeeRequest selectById(int request_id);
	

}
