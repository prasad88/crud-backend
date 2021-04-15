package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	
}
