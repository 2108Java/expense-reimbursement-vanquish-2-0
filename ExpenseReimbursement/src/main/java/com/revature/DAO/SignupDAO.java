package com.revature.DAO;

import java.util.List;

import com.revature.Models.SignUp;

public interface SignupDAO {
	//public void insert ();
	
	public List<SignUp> select();
	public void delete();
	
	public void update();

	void insert(SignUp signup);
	
	

}
