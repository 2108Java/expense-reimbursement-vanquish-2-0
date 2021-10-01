package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {
	
	/*
	 * This was discussed, we should create a .properties files to save
	 * the username, password, and url. Until you're finished in 
	 * the Controllers, use your local database now
	 */
	
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/Reimbursement";
	String username = "postgres";
	String password = "sp5hnug2";
	

	@Override
	public boolean getLogin(String user, String pass) {
		
		boolean success = false;
		
		try (Connection connect = DriverManager.getConnection(url, username, password)) {
			
			
			String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";
			
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, user);
			ps.setString(2, pass);

			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
					if ((rs.getString("username").equals(user)) 
							&& (rs.getString("password").equals(pass))) {
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
