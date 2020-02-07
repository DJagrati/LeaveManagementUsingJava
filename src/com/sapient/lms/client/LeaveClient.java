package com.sapient.lms.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.sapient.lms.model.Employee;
import com.sapient.lms.service.LeaveManager;
import com.sapient.lms.service.connectingDB;

public class LeaveClient {
	
	
	public static void main(String args[]) throws ParseException, SQLException{
		
		applyForLeave();
	        
		}
	
	public static  void applyForLeave() throws ParseException, SQLException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("EMP ID: ");
		int empID = sc.nextInt();
		System.out.println("start date: ");
		String sDate = sc.next();
		System.out.println("end Date: ");
		String eDate = sc.next();
		
		LeaveManager l = new LeaveManager();
        l.applyForLeave(empID, sDate, eDate);
		
	}
	
	public void newEmployee() throws SQLException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("EMP ID: ");
		int empID = sc.nextInt();
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Department: ");
		String dept = sc.next();
		
		Employee emp = new Employee(empID, name, dept);
		connectingDB connectDB = new connectingDB();
		connectDB.insertData(emp);
		
	}
	} 
	
	