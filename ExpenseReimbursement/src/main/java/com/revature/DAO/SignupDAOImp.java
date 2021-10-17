package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;

public class SignupDAOImp implements SignupDAO {
	
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "1983barada";
	
	SignUp signup = new SignUp ();
	List<SignUp> signup1= new ArrayList<>();

	//SignUp signup= new SignUp();
	
	 boolean success;
	@Override
	public void insert(SignUp signup) {
		
		 String sql = "INSERT INTO employees VALUES (?,?,?,?,?)";
		 
		 try(Connection connection = DriverManager.getConnection(url,username,password)){
		
		 
		 PreparedStatement ps = connection.prepareStatement(sql);
		 
			ps.setInt(1, signup.getEmployee_id());
			ps.setString(2, signup.getFirstname());
			ps.setString(3, signup.getLastname());
			ps.setString(4, signup.getEmail());
			ps.setString(5, signup.getPhone());
			
			 System.out.println("Congatulation u complete " );
			
			ps.execute();
			
			
			//r.setFirstname(ps.getString("firstname"));
			
			success = true;
			 //System.out.println("Congratulation");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Your Registration is successfully complete ");
		

	}
	
	@Override
	public List<SignUp> select() {
		// TODO Auto-generated method stub
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from employees  ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				/*String firstname=rs.getString("first_name");
				String lastname=rs.getString("last_name");
				String email=rs.getString("email");
				String c=rs.getString("contact");
				 a= rs.getString("password");
				 b=rs.getString("confirm_password");
				 
				 
				 System.out.println("First name is:- " + firstname + " Last Name is: " + lastname + " Email Address is:- " + email +
		                    " contact is:- " + c+"password is"+ a + "confirmed password is" + b );*/
				signup1.add(
						new SignUp(rs.getInt("employee_id"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
								rs.getString("phone")));
						
						

				}
			
			
			
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return signup1;
		}
	public SignUp  selectByEmail( String email) {
		SignUp signup = new SignUp ();
	
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			
		
		String sql = "select * from employees where email=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,signup.getEmail());
		System.out.println(signup.getEmail());
		
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			signup=new SignUp(rs.getInt("employee_id"), rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),
					rs.getString("phone"));
			System.out.println(rs.getString("firstname"));
		}}
		
		
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
		
	}

	

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
	public void update() {}

}
