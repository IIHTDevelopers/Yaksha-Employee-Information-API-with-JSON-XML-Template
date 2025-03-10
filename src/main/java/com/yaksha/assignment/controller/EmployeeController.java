package com.yaksha.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.dto.Employee;

@RestController
public class EmployeeController {

	@GetMapping(value = "/employee", produces = "application/xml")
	public Employee getEmployee() {
		// Hardcoded employee data
		return new Employee(1, "Alice Johnson", "Software Engineer");
	}
}
