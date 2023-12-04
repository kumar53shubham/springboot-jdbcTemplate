package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Employee e) {
		int save = jdbcTemplate.update("insert into employee(name,location,department) values(?,?,?)",new Object[] {e.getName(),e.getLocation(),e.getDepartment()});
		return save;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = jdbcTemplate.queryForObject("select * from employee where id=?", new BeanPropertyRowMapper<Employee>(Employee.class),id);
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}

	@Override
	public int update(Employee e, int id) {
		int update = jdbcTemplate.update("update employee set name=?,location=?,department=? where id = ?",new Object[] {e.getName(),e.getLocation(),e.getDepartment(),id});
		return update;
	}

	@Override
	public int deleteById(int id) {
		int delete = jdbcTemplate.update("delete from employee where id=?",id);
		return delete;
	}

}
