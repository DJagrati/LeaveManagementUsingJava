package com.sapient.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sapient.lms.model.Employee;

public class connectingDB {
	
	private static Connection getConnected() throws SQLException{

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LeaveMgmnt?useSSL=false","root","12345");
		return connection;
		 
	}
	
	public static void insertData(Employee employee) throws SQLException{
		
		try(Connection connection = getConnected();
				PreparedStatement prepareStmt = connection.prepareStatement("Insert into leaveBal(empName, empDep, noOfLeaves) values (?,?,?);");){
		
		
		prepareStmt.setString(1, employee.getEmpName());
		prepareStmt.setString(2, employee.getEmpDept());
		prepareStmt.setInt(3, 20);
		prepareStmt.execute();
		
		
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public static void updateData(int id, int n, String s){
		try(Connection connection = getConnected();
				Statement statement = connection.createStatement();){
			
			switch(n)
			{
			case 1:
			PreparedStatement prepareStmt = connection.prepareStatement("update leaveBal set empName = '?' where empID = ?");
			prepareStmt.setString(1, s);
			prepareStmt.setInt(2, id);
			prepareStmt.execute();
			System.out.println("Name Updated to " + s);
			prepareStmt.close();
			
			break;
			
			case 2:
				PreparedStatement prepareStmt1 = connection.prepareStatement("update leaveBal set empDept = '?' where empID = ?");
				prepareStmt1.setString(1, s);
				prepareStmt1.setInt(2, id);
				prepareStmt1.execute();
				System.out.println("Department Updated to " + s);
				prepareStmt1.close();
				
				break;
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}}
		
		public static void updateLeaves(int id, int leaves){
			try(Connection connection = getConnected();){
				
				
				PreparedStatement prepareStmt = connection.prepareStatement("update leaveBal set noOfLeaves = ? where empID = ?");
				prepareStmt.setInt(1, leaves);
				prepareStmt.setInt(2, id);
				prepareStmt.execute();
				System.out.println("You are left with " +leaves + " leaves now!!");
				prepareStmt.close();
			
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
			
			public static int getLeaves(int id) throws SQLException{
				
				Connection connection = getConnected();
						Statement statement = connection.createStatement();
					
						ResultSet resultSet = statement.executeQuery("select * from leaveBal where empID = " + id);	
						while(resultSet.next()){
							int leaves = resultSet.getInt("noOfLeaves");	
							return leaves;
						}
				    
					
					resultSet.close();
					statement.close();
					return 0;
					
			}
			
}
