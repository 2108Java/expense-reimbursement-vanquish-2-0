package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.ReimbursementRequest;

public class ReimbursementService {

	public static List<ReimbursementRequest> initialize(){
		
		//this should be in the database instead of the dummy list
		
		List<ReimbursementRequest> requestsList = new ArrayList<>();

	    requestsList.add(
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
	    
	    requestsList.add(
	        new ReimbursementRequest(
	            1, 
	            "food",
	            50, 
	            "3 meals",
	            "pending",
	            "10-01-2021",
	            "username1"
	        )
	        
	    );
	    
	    requestsList.add(
	        new ReimbursementRequest(
	            2, 
	            "travel",
	            1000, 
	            "Plane ticket",
	            "pending",
	            "10-01-2021",
	            "username1"
	        )
	        
	    );
	    
	    requestsList.add(
	        new ReimbursementRequest(
	            3, 
	            "lodging",
	            100, 
	            "Hotel",
	            "pending",
	            "10-01-2021",
	            "username1"
	        )
	        
	       
	    );
	    return requestsList;
		
	}
}
