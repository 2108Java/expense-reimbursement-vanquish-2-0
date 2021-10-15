package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import com.revature.models.Request;

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

			int i = 0;
			
			while(rs.next()) {
				requestList.add(new Request(
						rs.getInt("request_id"),
						rs.getString("request_type"),
						rs.getDouble("amount"),
						rs.getString("description"),
						rs.getString("request_status"),
						rs.getString("request_date"),
						rs.getInt("employee_id")
						));
				
			
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return requestList;
	}
	
	
	public boolean insertRequest(Request request) {
		
		boolean success = false;
		//2. Write a SQL statement String
		String sql = "INSERT INTO requests VALUES (?,?,?,?,?,?)";
		//1. Connect to database!
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){



			PreparedStatement ps = connection.prepareStatement(sql);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return success;
	}


	public Request selectRequestById(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean updateRequest(int id) {
		
		boolean success = false;
		
		
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){

			String sql = "UPDATE table requests SET request_status = ? WHERE id = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, "approved");
			ps.setInt(2, id);

			ps.execute();

			success = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return success;
		
	}

}
