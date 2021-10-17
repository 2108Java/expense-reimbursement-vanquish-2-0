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
		
		
		
			 
			 String sql = "INSERT INTO request14 VALUES (?,?,?,?,?,?,?)";
			 
			 try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			 
			 PreparedStatement ps = connection.prepareStatement(sql);
				//String x=Status.valueOf(r.getStatus());
			   ps.setInt(1, e.getRequest_id());
				ps.setString(2,e.getEmail());
				ps.setString(3,e.getReimbursment_type());

				//ps.setReimbursementRequest(2,r.getReimbursementType());
				ps.setString(4, e.getDescription());
				ps.setString(5,e.getStatus());
				ps.setString(6, e.getTime_of_request());
				ps.setString(7, e.getAmount());
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
			
			String sql = "select * from request14  ";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			//ReimbursementType re = ReimbursementType.valueOf(rs.getString("reimbursment_type"));
			//Status status =Status.valueOf(rs.getString("status"));
			while(rs.next()) {
				employee.add(
						new EmployeeRequest(rs.getInt("request_id"),rs.getString("email"),rs.getString("reimbursment_type"),rs.getString("description"),
								rs.getString("status"), rs.getString("time_of_request"), rs.getString("amount")
								)
						
						
						);
				
				

				}
			
			
			
			
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
return employee;

	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(EmployeeRequest e) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE request14 set status =? where email=?";
		 
		 try(Connection connection = DriverManager.getConnection(url,username,password)){
		
		 
		 PreparedStatement ps = connection.prepareStatement(sql);
			
		    //ps.setInt(1, e.getRequest_id());
			ps.setString(1,e.getEmail());
			 System.out.println(e.getEmail());
			ps.setString(2,e.getStatus());
			System.out.println(e.getStatus());

			//ps.setReimbursementRequest(2,r.getReimbursementType());
			//ps.setString(4, e.getDescription());
			//ps.setString(5,e.getStatus());
			//ps.setString(6, e.getTimeOfRequest());
			//ps.setString(7, e.getAmount());
			
		 
			
			 System.out.println("Congatulation your Update is complete " );
			
			
			ps.executeUpdate();
			
			
			
			success = true;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}
	@Override
	public EmployeeRequest selectByStatus( String status) {
		// TODO Auto-generated method stub
		//List<EmployeeRequest>	employee= null;
		EmployeeRequest employee=null;
		
try(Connection connection = DriverManager.getConnection(url,username,password)){
	
			String sql = "select * from request14 where status=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,status);
			
			
			ResultSet rs = ps.executeQuery();
			//ReimbursementType re = ReimbursementType.valueOf(rs.getString("reimbursment_type"));
			//Status status =Status.valueOf(rs.getString("status"));
			while(rs.next()) {
				
				
				employee=new EmployeeRequest(rs.getInt("request_id"),rs.getString("email"),rs.getString("reimbursment_type"),rs.getString("description"),
								status, rs.getString("time_of_request"), rs.getString("amount"));
								
						
						
						
						
						
				

				}
			
			
			
			
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       return employee;


	}
	@Override
	public EmployeeRequest selectById( int request_id) {
		// TODO Auto-generated method stub
		EmployeeRequest	u1= null;
		
try(Connection connection = DriverManager.getConnection(url,username,password)){
	
			String sql = "select * from request14 where request_id=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,request_id);
			
			
			ResultSet rs = ps.executeQuery();
			//ReimbursementType re = ReimbursementType.valueOf(rs.getString("reimbursment_type"));
			//Status status =Status.valueOf(rs.getString("status"));
			while(rs.next()) {
				
				
					u1=new EmployeeRequest(request_id,rs.getString("email"),rs.getString("reimbursment_type"),rs.getString("description"),
							rs.getString("status"), rs.getString("time_of_request"), rs.getString("amount")
								
						
						
						);
						
						
				

				}
			
			
			
			
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       return u1;


	}

	@Override
	public void iselect() {
		// TODO Auto-generated method stub
		
	}
	
		
	}

	
	


