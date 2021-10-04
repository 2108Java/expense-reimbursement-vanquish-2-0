package com.revature.repo;

import java.util.List;

import org.eclipse.jetty.server.Authentication.User;

public interface UserDao {

		public List<User> selectAllUsers();
		
		public User selectUserById(int id);
		
		public User selectUserByUsername(String username);
		
		public boolean insertUser(User user);
		
		public boolean updateUser(User user);
		
}
