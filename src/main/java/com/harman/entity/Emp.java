package com.harman.entity;
import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="harman_employee")
@DynamicUpdate

public class Emp {
	
	@Id
	@Column(name="emp_id")
	private int empID;
	
	@Column(name="emp_name",nullable = false,length = 30)
	private String empName;
	
	@Column(name="emp_sal")
	private double empsal;
	
	@Column(name = "emp_dept")
	private String empDept;
	
	@Column(name = "emp_doj")
	private LocalDate doj;
	
	
	//getters and setters
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpsal() {
		return empsal;
	}
	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Emp [empID=" + empID + ", empName=" + empName + ", empsal=" + empsal + ", empDept=" + empDept + ", doj="
				+ doj + "]";
	}
	
	
	
	
	

}


