package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import com.revature.Models.EmployeeRequest;
import com.revature.Models.ReimbursementRequest;

public class RequestDAOImp implements RequestDAO {
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "1983barada";
	List<EmployeeRequest>   employee = new ArrayList<>();
	

	
	
	 boolean success;
	
	 //ReimbursementRequest r= new ReimbursementRequest();
	 EmployeeRequest e =new EmployeeRequest();
	 
	
		//System.out.println

	public void insert( EmployeeRequest e) {
		// TODO Auto-generated method stub
		
		
		
		/*System.out.println("Enter your Email: ");
			s=  sc.nextLine();
			

			
			 
		    System.out.println("Enter your reimbursement Type: " );
			 //s2=  sc.nextLine();
			 
			 System.out.println("Enter you description:");
			 s3=  sc.nextLine();
			 
			 System.out.println("your status is:" + s4);
			s4= "pending";
			 
			 System.out.println("Time of request:");
			 s5=  sc.nextLine();
			 
			 System.out.println("Enter your amount: " );
			 s1=  sc.nextDouble();*/
			 
			 String sql = "INSERT INTO request1 VALUES (?,?,?,?,?,?)";
			 
			 try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			 
			 PreparedStatement ps = connection.prepareStatement(sql);
				//String x=Status.valueOf(r.getStatus());
				ps.setString(1,e.getEmail());
				ps.setString(2,e.getRetype());

				//ps.setReimbursementRequest(2,r.getReimbursementType());
				ps.setString(3, e.getDescription());
				ps.setString(4,e.getStatus());
				ps.setString(5, e.getTimeOfRequest());
				ps.setDouble(6, e.getAmount());
			// ps.setString(1, s);
			 //ps.setString(3, s2);
			// ps.setString(5, s4);
			// ps.setString(6, s5);
			 
				
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
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 //System.out.println("Your request is successfuly submitted: " );
			 

	}

	@Override
	public List<EmployeeRequest> select() {
		
		
		// TODO Auto-generated method stub
		
try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from request1  ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			//ReimbursementType re = ReimbursementType.valueOf(rs.getString("reimbursment_type"));
			//Status status =Status.valueOf(rs.getString("status"));
			while(rs.next()) {
				employee.add(
						new EmployeeRequest(rs.getString("email"),rs.getString("reimbursment_type"),rs.getString("description"),
								rs.getString("status"), rs.getString("time_of_request"), rs.getDouble("amount")
								)
						
						
						);
				
				/*String email=rs.getString("email");
				
				Double amount=rs.getDouble("amount");
				String d=rs.getString("description");
				 a= rs.getString("status");
				 b=rs.getString("timeOfRequest");
				 String r=rs.getString("reimbursementType");*/
				 
				 
				// System.out.println("Email is:- " + email + "reimbursement Type is: "  +
		                    //" description is:- " + d +"status is"+ a + "time of request is" + b + r + " amount is:- " +amount);

				}
			
			
			
			
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
return employee;

	}
	/*public void iselect() {
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
		
	}*/

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeRequest selectByEmail(String email) {
		// TODO Auto-generated method stub
		EmployeeRequest u= null;
		
try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from request1 where email=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,e.getEmail());
			
			
			ResultSet rs = ps.executeQuery();
			//ReimbursementType re = ReimbursementType.valueOf(rs.getString("reimbursment_type"));
			//Status status =Status.valueOf(rs.getString("status"));
			while(rs.next()) {
				
						u=new EmployeeRequest(rs.getString("email"),rs.getString("reimbursment_type"),rs.getString("description"),
								rs.getString("status"), rs.getString("time_of_request"), rs.getDouble("amount")
								);
						
						
						
				
				/*String email=rs.getString("email");
				
				Double amount=rs.getDouble("amount");
				String d=rs.getString("description");
				 a= rs.getString("status");
				 b=rs.getString("timeOfRequest");
				 String r=rs.getString("reimbursementType");*/
				 
				 
				// System.out.println("Email is:- " + email + "reimbursement Type is: "  +
		                    //" description is:- " + d +"status is"+ a + "time of request is" + b + r + " amount is:- " +amount);

				}
			
			
			
			
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
return u;


	}

	@Override
	public void iselect() {
		// TODO Auto-generated method stub
		
	}
	
		
	}

	
	


