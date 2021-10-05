package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.revature.models.ReimbursementRequest;

import io.javalin.http.Context;

public class ReimbursementController {
	
	private List<ReimbursementRequest>  reimbursementList = new ArrayList<>();
	

	public void initalizeList() {
		// TODO Auto-generated method stub
		
		
		reimbursementList.add(
				new ReimbursementRequest(
						1, 
						"travel",
						1000, 
						"Plane ticket",
						"10-01-2021",
						"pending",
						"username1"
				)
				
		);
		
		reimbursementList.add(
				new ReimbursementRequest(
						1, 
						"food",
						50, 
						"3 meals",
						"10-01-2021",
						"pending",
						"username1"
				)
				
		);
		
		reimbursementList.add(
				new ReimbursementRequest(
						2, 
						"food",
						1000, 
						"Plane ticket",
						"10-01-2021",
						"pending",
						"username1"
				)
				
		);
		
		reimbursementList.add(
				new ReimbursementRequest(
						3, 
						"lodging",
						100, 
						"Hotel",
						"10-01-2021",
						"pending",
						"username1"
				)
				
		);
		
		
	}

	public ReimbursementRequest getReimbursement(Context ctx) {
		// TODO Auto-generated method stub
		return this.reimbursementList.get(0);
	}

	public List<ReimbursementRequest> getAllRequests(Context ctx) {
		
		
		ctx.res.setStatus(200);
		return this.reimbursementList;
	}

}
