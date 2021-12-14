package com.harman.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harman.dao.EmpRepo;
import com.harman.dto.EmpDto;
import com.harman.dto.SuccessMessage;
import com.harman.entity.Emp;
import com.harman.exception.EmpNotFoundException;
import com.harman.exception.IdAlreadyExistsException;

@RestController
@RequestMapping("/empcrud")
public class EmployeeCRUDRestController {
	
	@Autowired
	private EmpRepo repo;
	
	@GetMapping(value = "/viewbydojrange/{dojFrom}/{dojTo}")
	public List<Emp> viewEmployee(@PathVariable("dojFrom")@DateTimeFormat(pattern="yyyy-M-d")LocalDate startDoj,@PathVariable("DojTo")@DateTimeFormat(pattern="yyyy-M-d")LocalDate endDoj){
		List<Emp> lst = repo.getEmployeeByDojRange(startDoj,endDoj);
		return lst;
	}
	
	
	@PostMapping("/addemployee}")
	public SuccessMessage addEmployee(@RequestBody EmpDto empdto) throws IdAlreadyExistsException {
		
		Optional<Emp> optemp = repo.findById(empdto.getEmpId());
		if(optemp.isPresent())
			throw new IdAlreadyExistsException("Id" +empdto.getEmpId() +"Already exists");
		Emp emp= new Emp();
		emp.setEmpID(empdto.getEmpId());
		emp.setEmpDept(empdto.getEmpDept());
		emp.setEmpName(empdto.getEmpName());
		emp.setDoj(empdto.getEmpDoj());
		emp.setEmpsal(empdto.getEmpSal());
		repo.save(emp);
		return new SuccessMessage("employee added successfully");
			
	}
	
	@DeleteMapping("/remove/{empid}")
	public SuccessMessage removeEmployee (@PathVariable("empid") int eid) throws EmpNotFoundException{
		Optional<Emp> optemp = repo.findById(eid);
		if (optemp.isEmpty())
			throw new EmpNotFoundException("Employee not found, please enter correct Id");	
	
		Emp emp= optemp.get();
		repo.delete(emp);
		return new SuccessMessage("Employee Deleted");
		
		}
	
	@PutMapping("/editemp")
	public SuccessMessage editEmployee(@RequestBody EmpDto empDto ) throws EmpNotFoundException{
		Optional<Emp> optemp = repo.findById(empDto.getEmpId());
		if (optemp.isEmpty())
			throw new EmpNotFoundException("Employee not found, please enter correct Id");	
	
		Emp emp= optemp.get();
		emp.setEmpName(empDto.getEmpName());	
		emp.setEmpsal(empDto.getEmpSal());
		emp.setEmpDept(empDto.getEmpDept());
		emp.setDoj(empDto.getEmpDoj());
		repo.save(emp);	
		return new SuccessMessage("Employee updated successfully");
		
	}
	}
	


