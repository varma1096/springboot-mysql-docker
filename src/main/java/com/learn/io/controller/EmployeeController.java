package com.learn.io.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.io.model.Employee;
import com.learn.io.repository.EmployeeRepo;

@RestController
public class EmployeeController {
		
		@Autowired
		EmployeeRepo repo;
		
		@GetMapping("/hello")
		public String hello() {
			return "hello";
		}
	
		@GetMapping("/employees")
		public List<Employee> getEmployee(){
//			System.out.println("In Get all");
			return repo.findAll();
		}
	
		@PostMapping(path="/addEmployee")                //,consumes="application/json"
//		@ResponseBody
		public Employee addEmployee(@RequestBody Employee emp) {
			//System.out.println("In Post ");
			System.out.println(emp);
			repo.save(emp);
			System.out.println(emp);
			return emp;
		}
		
		@GetMapping("/employees/{eid}")
 		public Optional<Employee> updateEmployee(@PathVariable("eid") int eid){
//			System.out.println("In Get One Id");
			Optional<Employee> e = repo.findById(eid);
			return e;
		}
		
		@PutMapping("/employees/{eid}")
 		public String getOneEmployee(@PathVariable("eid") int eid, @RequestBody Employee emp){
//			System.out.println("In put One Id");
			emp.setId(eid);
//			System.out.println(emp);
			repo.save(emp);
			return "Updated";
		}
		
		@DeleteMapping("/employees/{eid}")
 		public String delEmployee(@PathVariable("eid") int eid){
//			System.out.println("In Del One Id");
			Employee e = repo.getOne(eid);
//			System.out.println(e.toString());
			repo.delete(e);	
			return "Deleted";
		}
		
		
}
