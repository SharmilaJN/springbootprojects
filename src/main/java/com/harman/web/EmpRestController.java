package com.harman.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harman.dao.EmpRepo;
import com.harman.entity.Emp;
import com.harman.exception.EmpNotFoundException;

//expose this class as a webservice
@RestController
@RequestMapping("/employee")
public class EmpRestController {
	
	//dependency Emprepo
	@Autowired
	private EmpRepo repo;
	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	//@GetMapping(value= "/viewall" , produces= "application/json")
	public List<Emp> viewEmployee(){
		List<Emp> elst= repo.findAll();
		return elst;
	}
	
	
	@GetMapping(value= "/viewbyid/{empid}" , produces= "application/json")
	public Emp viewEmployee (@PathVariable("empid") int eid) throws EmpNotFoundException {
		
		Optional <Emp> optemp = repo.findById(eid);
		
		if(optemp.isEmpty())
			throw new EmpNotFoundException("emp not found for"+eid);
		Emp emp=optemp.get();
		return emp;
	}
	
	
	
	
	
	
}
