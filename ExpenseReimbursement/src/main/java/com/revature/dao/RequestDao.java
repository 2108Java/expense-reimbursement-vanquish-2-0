package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.revature.models.Employee;
import com.revature.models.Request;

import io.javalin.http.Context;

public class RequestDao {
	
	String url = "jdbc:postgresql://localhost/";
	String username = "postgres";
	String password = "";

	public List<Request> selectAllRequests() {
		
		List<Request> requestList = new ArrayList<>();	
		
		String sql = "SELECT * FROM requests";

		try{
			Connection connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			
			while(rs.next()) {
				requestList.add(new Request(
						rs.getInt("request_id"),
						rs.getString("request_type"),
						rs.getDouble("amount"),
						rs.getString("description"),
						rs.getString("request_status"),
						rs.getString("request_date"),
						rs.getInt("fk_employee_id")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return requestList;
	}
	
	
	public boolean insertRequest(Request request) {
		
		//a request cannot exist without an employee creating it, 
		// this employee should already exist in the employees table, we just need his/her id as an input in the form when a request is created
		//by looking at the employee table, there are currently 6 employees with ids ranging from 1 to  6
		//let us assume it is employee with id 1 who is making this request.
		//in this case all we need to do is enter the value 1 as a value for fk_employee_id when inserting the request object to database
		
	
		boolean success = false;
	
		//1. Connect to database!
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){

			//2. Write a SQL statement String
			
			//NB: amount and employeeId get specified when an employee is filling out the request form. 
			//the status is set to  pending by default, and only a manager can change that when processing the request
			//The selected columns that need to have data inserted into them are:
			//also, date can be set to automatically be inserted by the database using timestamp syntax, 
			//for now employee will enter it as a string, but it's simple to modify later
			
			
			String sql = "INSERT INTO requests(request_type, amount, description,request_status request_date, fk_employee_id) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			//in fact, we don't need to insert a request id, the database does that for us since it's set to serial
			ps.setInt(1, request.getRequestId());
			ps.setString(2, request.getRequestType());
			ps.setDouble(3, request.getAmount());
			ps.setString(4, request.getDescription());
			ps.setString(5, request.getRequestStatus());
			ps.setString(6, request.getRequestDate());
			ps.setInt(7, request.getEmployeeId());

			ps.execute();

			success = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}


		return success;
	}


	public Request selectRequestById(int requestId) {
		Request request = null;	
		try{
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String sql = "SELECT * FROM requests WHERE request_id = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1,  requestId);

			ResultSet rs = ps.executeQuery();


			while(rs.next()) {
				request = (new Request(
						rs.getInt("request_id"),
						rs.getString("request_type"),
						rs.getDouble("amount"),
						rs.getString("description"),
						rs.getString("request_status"),
						rs.getString("request_date"),
						rs.getInt("fk_employee_id")
						));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return request;

	}
	
	
	public boolean updateRequest(int requestId, String decision) {
		
		boolean success = false;
		
		
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){

			String sql = "UPDATE table requests SET request_status = ? WHERE request_id = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, decision);
			ps.setInt(2, requestId);

			ps.execute();

			success = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return success;
		
	}


	public List<Request> selectEmployeeRequests(int employeeId) {
		
		
		List<Request> employeeRequests = new ArrayList<>();	
		
		String sql = "SELECT * FROM requests WHERE fk_employee_id = ?";

		try{
			Connection connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();

			
			while(rs.next()) {
				employeeRequests.add(new Request(
						rs.getInt("request_id"),
						rs.getString("request_type"),
						rs.getDouble("amount"),
						rs.getString("description"),
						rs.getString("request_status"),
						rs.getString("request_date"),
						rs.getInt("fk_employee_id")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employeeRequests;
	}


	public List<Request> selectEmployeePendingRequests(int employeeId) {
		
		List<Request> employeePendingRequests = new ArrayList<>();	
		
		String sql = "SELECT * FROM requests WHERE fk_employee_id = ? AND request_status ILIKE 'pending'";

		try{
			Connection connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();

			
			while(rs.next()) {
				employeePendingRequests.add(new Request(
						rs.getInt("request_id"),
						rs.getString("request_type"),
						rs.getDouble("amount"),
						rs.getString("description"),
						rs.getString("request_status"),
						rs.getString("request_date"),
						rs.getInt("fk_employee_id")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employeePendingRequests;
	}


	public List<Request> selectRequestsByUsername(String username) {
		List<Request> requestListByUsername = new ArrayList<>();
		

		String sql = "SELECT * FROM requests WHERE fk_employee_id = (SELECT employee_id FROM employees WHERE username = ?)";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			 
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				requestListByUsername.add(new Request(
						
						rs.getInt("request_id"),
						rs.getString("request_type"),
						rs.getDouble("amount"),
						rs.getString("description"),
						rs.getString("request_status"),
						rs.getString("request_date"),
						rs.getInt("fk_employee_id")
						));
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return requestListByUsername;
	}

}
