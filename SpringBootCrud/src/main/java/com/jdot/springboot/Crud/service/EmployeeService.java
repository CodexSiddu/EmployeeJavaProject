package com.jdot.springboot.Crud.service;

import java.util.List;

import com.jdot.springboot.Crud.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);

	public Employee getEmployeeById(long id);

	public List<Employee> getEmployees();

	public Employee updateEmployee(Employee emp);

	public void deleteEmployee(long id);
}
