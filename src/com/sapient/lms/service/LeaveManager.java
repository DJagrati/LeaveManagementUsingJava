package com.sapient.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.lms.model.*;

public class LeaveManager extends LeaveDetails{
	
	int leaves;
	
	public boolean applyForLeave(int eID, String sDate, String eDate) throws ParseException, SQLException{
		
		connectingDB dataFromDB = new connectingDB();
		leaves = dataFromDB.getLeaves(eID);
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		Date startDate = df.parse(sDate);
		Date endDate = df.parse(eDate);
		boolean flag = true;
		
		try{
			if(endDate.after(startDate)){
				
				
		long noOfLeavesWanted =  (long)((endDate.getTime() - startDate.getTime())/ (double) 86400000);
		System.out.println(noOfLeavesWanted);
		if(noOfLeavesWanted > leaves){
			System.out.println("No of Payable leaves are less, kindly report leaves to PL!");
		}
		else{
			leaves -= noOfLeavesWanted;
			System.out.println("Leave Granted");
			dataFromDB.updateLeaves(eID, leaves);
		}
		}
				
	}

        catch(Exception e){
			System.out.println("You don't have this much payable leaves!");
		}
		return flag;	
	}
	
	
	
	
	public int viewLeaveBalance(int empID){
		
		return(leaves);
		
	}
	
		
}

