package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psl.dao.EmployeeDAO;
import com.psl.employee.Employee;

@RestController
public class PagedController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employees/p-{pageNumber}")
	public List<Employee> getPage(@PathVariable("pageNumber") int pageNumber) {
		return employeeDAO.getPage(pageNumber);
	}
}
