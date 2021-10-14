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
	Scanner sc =new Scanner(System.in);
	SignUp signup = new SignUp ();
	List<SignUp> signup1= new ArrayList<>();

	
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
		/*System.out.println("Enter your First name: ");
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
		 s5=  sc.nextLine();*/
		 
		 String sql = "INSERT INTO employees VALUES (?,?,?,?,)";
		 
		 try(Connection connection = DriverManager.getConnection(url,username,password)){
		
		 
		 PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, signup.getFirst_name());
			ps.setString(2, signup.getLast_name());
			ps.setString(3, signup.getEmail());
			ps.setString(4, signup.getContact());
			
			
			//validate();
			
			/*ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				
				String a= rs.getString("password");
				String b=rs.getString("confirmed_password");
				}*/
			ps.execute();
			
			
			//r.setFirstname(ps.getString("firstname"));
			
			success = true;
			 System.out.println("Congratulation");
			
			
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
						new SignUp(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
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
		SignUp su= null;
	
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			
		
		String sql = "select * from employees where email=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,su.getEmail());
		System.out.println(su.getEmail());
		
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			su=new SignUp(rs.getString("firstname"),rs.getString("lastname"),su.getEmail(),
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
