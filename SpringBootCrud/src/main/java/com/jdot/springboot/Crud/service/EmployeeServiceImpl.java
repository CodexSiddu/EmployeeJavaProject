package com.jdot.springboot.Crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdot.springboot.Crud.entity.Employee;
import com.jdot.springboot.Crud.error.RecordNotFoundException;
import com.jdot.springboot.Crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			Employee e = employeeDb.get();
			return e;

		} else {
			throw new RecordNotFoundException("Record not found");
		}
	}

	@Override
	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> employeeDb = employeeRepository.findById(emp.getEmployeeId());
		if (employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setEmail(emp.getEmail());
			employeeUpdate.setSalary(emp.getSalary());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new RecordNotFoundException("Record not found");
		}

	}

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			employeeRepository.delete(employeeDb.get());
		} else {
			throw new RecordNotFoundException("Record not found");
		}

	}

}
