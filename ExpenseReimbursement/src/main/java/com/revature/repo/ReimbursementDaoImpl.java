package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.ReimbursementRequest;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public boolean insertReimbursementRequest(ReimbursementRequest request) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO Reimbursment_Request (reimbursement, amount, description, status_of_request, time_of_request, fk_username) VALUES()?,?,?,?,?";
		
		boolean success = false;
		
		try(Connection connection = DriverManager.getConnection(sql)){
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, request.getReimbursementType());
			ps.setDouble(2, request.getAmount());
			ps.setString(3, request.getDescription());
			ps.setString(4, request.getStatus());
			ps.setString(5, request.getTimeOfRequest());
			ps.setString(6, request.getUsername());
			
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public List<ReimbursementRequest> selectAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementRequest> selectPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementRequest> selectRejectedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementRequest> selectApprovedRequests() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ReimbursementRequest selectRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementRequest selectRequestByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementRequest selectRequestByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequest(ReimbursementRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRequest(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
