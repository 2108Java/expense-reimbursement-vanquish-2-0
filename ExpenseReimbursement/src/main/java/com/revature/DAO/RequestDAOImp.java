package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import com.revature.Models.ReimbursementRequest;

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
	 ReimbursementRequest r= new ReimbursementRequest();
	 
	
		//System.out.println

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Enter your Email: ");
			s=  sc.nextLine();
			

			
			 
		    System.out.println("Enter your reimbursement Type: " );
			 s2=  sc.nextLine();
			 
			 System.out.println("Enter you description:");
			 s3=  sc.nextLine();
			 
			 System.out.println("your status is:" + s4);
			s4= "pending";
			 
			 System.out.println("Time of request:");
			 s5=  sc.nextLine();
			 
			 System.out.println("Enter your amount: " );
			 s1=  sc.nextDouble();
			 
			 String sql = "INSERT INTO request1 VALUES (?,?,?,?,?,?)";
			 
			 try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			 
			 PreparedStatement ps = connection.prepareStatement(sql);
				//String x=Status.valueOf(r.getStatus());
				ps.setString(1,s);

				ps.setString(2,s2);
				ps.setString(3, s3);
				ps.setString(4,s4);
				ps.setString(5, s5);
				ps.setDouble(6, s1);
				
				 System.out.println("Congatulation u complete " );
				
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
			 //System.out.println("Your request is successfuly submitted: " );
			 

	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from request1 where status=r.getStatus()  ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String email=rs.getString("email");
				
				Double amount=rs.getDouble("amount");
				String d=rs.getString("description");
				 a= rs.getString("status");
				 b=rs.getString("timeOfRequest");
				 String r=rs.getString("reimbursementType");
				 
				 
				 System.out.println("Email is:- " + email + "reimbursement Type is: "  +
		                    " description is:- " + d +"status is"+ a + "time of request is" + b + r + " amount is:- " +amount);

				}
			
			
			
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void iselect() {
		try(Connection connection = DriverManager.getConnection(url,username,password)){
		String sql = "select * from request1 where email=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setNString(0, s);
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			String email=rs.getString("email");
			
			Double amount=rs.getDouble("amount");
			String d=rs.getString("description");
			 a= rs.getString("status");
			 b=rs.getString("timeOfRequest");
			 String r=rs.getString("reimbursementType");
			 
			 
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
