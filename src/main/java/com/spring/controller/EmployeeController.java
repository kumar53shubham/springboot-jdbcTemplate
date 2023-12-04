package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.EmployeeDao;
import com.spring.entity.Employee;

@RestController
@RequestMapping("/shubham-hardware")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		int save = employeeDao.save(employee);
		return "Employee "+save+" saved successfully";
	}
	
	@GetMapping("/employees/{id}")
	public Employee findOneEmployee(@PathVariable("id") int id){
		Employee findById = employeeDao.findById(id);
		return findById;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		List<Employee> list = employeeDao.findAll();
		return list;
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
		int update = employeeDao.update(employee, id);
		return "Employee "+update+" updated successfully";
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		int delete = employeeDao.deleteById(id);
		return "Employee "+delete+" deleted successfully";
	}
}
