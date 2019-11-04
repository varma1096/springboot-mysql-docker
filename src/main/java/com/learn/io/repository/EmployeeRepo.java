package com.learn.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.io.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
