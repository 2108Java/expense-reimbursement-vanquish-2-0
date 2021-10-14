package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Models.User;

import util.ConnectionFactory;

public class UserDAO {
	ConnectionFactory cf = new ConnectionFactory();
	//User u = new User();
	public User selectByUsername(String username) {
		User u = null;
		 boolean status = false;
		try{
			Connection connection =cf.connection();

		String sql = "select * from users where username=?  ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,username);
		//ps.setString(2,u.getPassword());
		
		ResultSet rs = ps.executeQuery();
		//status = rs.next();
		while(rs.next()) {
			u= new User(rs.getInt("user_id"),username, rs.getString("password"));
		}


		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return u;
		
	}

}
