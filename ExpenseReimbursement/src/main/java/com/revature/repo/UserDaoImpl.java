package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.jetty.server.Authentication.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAllUsers() {
		
		return null;
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		
		final String URL = "jdbc:postgresql://localhost/";
		final String USERNAME = "postgres";
		final String PASSWORD = "";
		String sql = "INSERT INTO users(username, password, isManager) VALUES(?,?,?)";
		
		try{
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, ctx.formParam("username"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
