package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.models.Request;

public class EmployeeDao {
	
	String url = "jdbc:postgresql://localhost/";
	String username = "postgres";
	String password = "";

	public int selectEmployeeId() {

		return 0;
	}

	public String selectEmployeeEmail() {

		return "";
	}

	public String selectEmployeeUsername() {

		return "";
	}

	public String selectEmployeePassword() {

		return "";
	}

	public Employee selectEmployeeById(int id) {
		
		Employee employee = null;	
		try{
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String sql = "SELECT * FROM employees WHERE employeeId = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();


			while(rs.next()) {
				employee = (new Employee(
						rs.getInt("employee_id"),
						rs.getString("employee_email"),
						rs.getString("employee_username"),
						rs.getString("employee_password")
						));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return employee;

	}

}
