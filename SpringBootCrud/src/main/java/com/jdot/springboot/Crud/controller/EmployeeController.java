package com.jdot.springboot.Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdot.springboot.Crud.entity.Employee;
import com.jdot.springboot.Crud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return ResponseEntity.ok().body(employeeService.saveEmployee(emp));
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok().body(employeeService.getEmployees());

	}

	@PutMapping("/employee/{id}")   // http://localhost:9000/employee/1
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee emp) {
		emp.setEmployeeId(id);
		return ResponseEntity.ok().body(employeeService.updateEmployee(emp));

	}
          here the response entity shouldd be monolithic architecture apply the changes run the unit testing , push the code to the git
	@DeleteMapping("/employee/{id}")  // http://localhost:9000/employee/1
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().body("Record deleted");
	}
}
