package com.revature.repo;



import java.util.List;

import com.revature.models.ReimbursementRequest;

public interface ReimbursementDao {
	
	public boolean insertReimbursementRequest(ReimbursementRequest request);
	
	public List<ReimbursementRequest> selectAllRequests();
	
	public List<ReimbursementRequest> selectPendingRequests();
	
	public List<ReimbursementRequest> selectRejectedRequests();
	
	public List<ReimbursementRequest> selectApprovedRequests();
	
	public ReimbursementRequest selectRequestById(int id);
	
	public ReimbursementRequest selectRequestByUsername(String username);
	
	public ReimbursementRequest selectRequestByEmail(String email);
	
	public boolean updateRequest(ReimbursementRequest request);
	
	public boolean deleteRequest(int id);
	
	


}
