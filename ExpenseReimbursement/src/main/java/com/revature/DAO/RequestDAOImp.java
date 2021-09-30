package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RequestDAOImp implements RequestDAO {
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "1983barada";
	Scanner sc =new Scanner(System.in);

	
	 String s;
	 Double s1;
	 String s2;
	 String s3;
	 String s4;
	 String s5;
	 String a;
	 String b;
	 boolean success;
	 
	
		//System.out.println

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		 System.out.println("Enter your Email: ");
			s=  sc.nextLine();
			

			System.out.println("Enter your amount: " );
			 s1=  sc.nextDouble();
			 
		    System.out.println("Enter your description: " );
			 s2=  sc.nextLine();
			 
			 System.out.println("Enter you Contact Number:");
			 s3=  sc.nextLine();
			 
			 System.out.println("yor status is:");
			 s4=  "pending";
			 
			 System.out.println("Time of request:");
			 s5=  sc.nextLine();
			 
			 String sql = "INSERT INTO request VALUES (?,?,?,?,?,?)";
			 
			 try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			 
			 PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, s);
				ps.setDouble(2, s1);
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

	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from request  ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String email=rs.getString("email");
				String r=rs.getString("reimbursementType");
				Double amount=rs.getDouble("amount");
				String d=rs.getString("description");
				 a= rs.getString("status");
				 b=rs.getString("timeOfRequest");
				 
				 
				 System.out.println("Email is:- " + email + "reimbursement Type is: " + r + " amount is:- " +amount +
		                    " description is:- " + d +"status is"+ a + "time of request is" + b );

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

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
