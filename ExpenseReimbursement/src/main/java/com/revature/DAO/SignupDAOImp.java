package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SignupDAOImp implements SignupDAO {
	
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "1983barada";
	Scanner sc =new Scanner(System.in);

	
	 String s;
	 String s1;
	 String s2;
	 String s3;
	 String s4;
	 String s5;
	 String a;
	 String b;
	 boolean success;
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Enter your First name: ");
		s=  sc.nextLine();
		

		System.out.println("Enter you Last name: " );
		 s1=  sc.nextLine();
		 
	    System.out.println("Enter your Email: " );
		 s2=  sc.nextLine();
		 
		 System.out.println("Enter you Contact Number:");
		 s3=  sc.nextLine();
		 
		 System.out.println("Enter you password:");
		 s4=  sc.nextLine();
		 
		 System.out.println("Comfirm your pasword:");
		 s5=  sc.nextLine();
		 
		 String sql = "INSERT INTO signup1 VALUES (?,?,?,?,?,?)";
		 
		 try(Connection connection = DriverManager.getConnection(url,username,password)){
		
		 
		 PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, s);
			ps.setString(2, s1);
			ps.setString(3, s2);
			ps.setString(4, s3);
			ps.setString(5, s4);
			ps.setString(6, s5);
			
			
			
			//validate();
			
			/*ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				
				String a= rs.getString("password");
				String b=rs.getString("confirmed_password");
				}*/
			ps.execute();
			
			
			//r.setFirstname(ps.getString("firstname"));
			
			success = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Your Registration is successfully complete ");
		

	}
	
	@Override
	public void select() {
		// TODO Auto-generated method stub
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from signup1  ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String firstname=rs.getString("first_name");
				String lastname=rs.getString("last_name");
				String email=rs.getString("email");
				String c=rs.getString("contact");
				 a= rs.getString("password");
				 b=rs.getString("confirm_password");
				 
				 
				 System.out.println("First name is:- " + firstname + " Last Name is: " + lastname + " Email Address is:- " + email +
		                    " contact is:- " + c+"password is"+ a + "confirmed password is" + b );

				}
			
			
			
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
	public void update() {}

}
