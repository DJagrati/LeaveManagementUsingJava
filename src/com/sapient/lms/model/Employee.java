package com.sapient.lms.model;

public class Employee {
	
	private int empID;
	private String EmpName;
	private String empDept;
	private LeaveDetails leaveDetails;
	
	

	public Employee(int empID, String empName, String empDept) {
		
		
		this.empID = empID;
		EmpName = empName;
		this.empDept = empDept;
		
	}


	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

}
