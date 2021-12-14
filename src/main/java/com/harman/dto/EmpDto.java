package com.harman.dto;

import java.time.LocalDate;
                   
public class EmpDto {

	
	private int  empId;
	private String empName;
	private double empSal;
	private String empDept;
	private LocalDate empDoj;
	
	public EmpDto(int empId, String empName, double empSal, String empDept, LocalDate empDoj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDept = empDept;
		this.empDoj = empDoj;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}
	

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	
	public LocalDate getEmpDoj() {
		return empDoj;
	}
	
	public void setEmpDoj(LocalDate doj) {
		this.empDoj=doj;
	}
	
	
	
}
