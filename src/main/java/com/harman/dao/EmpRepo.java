package com.harman.dao;

import java.time.LocalDate;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.harman.entity.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp,Integer> {

	public List<Emp> findByEmpDept(String dept);
	
	//Springdata writes query as from Emp where empDept=?
	
	@Query("from Emp where doj>=:sDoj and doj<=:eDoj")
	public List<Emp> getEmployeeByDojRange(@Param("sDoj")LocalDate startDoj, @Param("eDoj")LocalDate endDoj);
	
	public List<Emp> findByDoj(LocalDate doj);
	 //springData write query as from Emp where doj=?
	
	
	
	 
}
