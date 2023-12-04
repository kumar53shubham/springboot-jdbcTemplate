package com.spring.dao;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeDao {

	int save(Employee e);
	Employee findById(int id);
	List<Employee> findAll();
	int update(Employee e,int id);
	int deleteById(int id);
	
	
}
