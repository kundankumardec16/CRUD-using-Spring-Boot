package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psl.dao.EmployeeDAO;
import com.psl.pages.PageOutput;

@RestController
public class PagedController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employees/pgn-{pageNumber}/pgs-{pageSize}")
	public PageOutput gotoPage(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
		PageOutput pageOutput = employeeDAO.gotoPage(pageNumber, pageSize);
		return pageOutput;
	}
}
