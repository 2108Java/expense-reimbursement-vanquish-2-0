package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {
	
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/Reimbursement";
	String username = "postgres";
	String password = "sp5hnug2";
	

	@Override
	public boolean getLogin(String user, String pass) {
		
		boolean success = false;
		
		try (Connection connect = DriverManager.getConnection(url, username, password)) {
			
			
			String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";
			
			PreparedStatement PS = connect.prepareStatement(query);
			
			PS.setString(1, user);
			PS.setString(2, pass);
			
			ResultSet RS = PS.executeQuery();
			
			while (RS.next()) {
				
				if ((RS.getString("username").equals(user)) 
						&& (RS.getString("password").equals(pass))) {
					success = true;
				} else {
					success = false;
				}
				
			
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return success;
	}

}
