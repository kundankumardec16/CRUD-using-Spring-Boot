package com.psl.dao;

//import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Repository;

import com.psl.employee.Employee;
import com.psl.pages.PageOutput;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// https://www.geeksforgeeks.org/spring-boot-h2-database/
	@Async
	public CompletableFuture<List<Employee>> getEmployees() {
		return CompletableFuture.completedFuture(employeeRepository.getAllEmployees());
	}
	
//	public Future<List<Employee>> getEmployees() {
//		return  new AsyncResult<List<Employee>>(employeeRepository.findAll());
//	}
	
	public Employee getEmployeeById(long id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee editEmployeeById(long id, Employee employee) {
		Employee emp = this.getEmployeeById(id);
		
		if (employee.getEmpName() != null) {
			emp.setEmpName(employee.getEmpName());
		}
		
		if (employee.getEmpDesignation() != null) {
			emp.setEmpDesignation(employee.getEmpDesignation());
		}
		
		if (employee.getEmpDepartment() != null) {
			emp.setEmpDepartment(employee.getEmpDepartment());
		}
		
		if (employee.getEmpSalary() != null) {
			emp.setEmpSalary(employee.getEmpSalary());
		}
		
		return employeeRepository.save(emp);
	}
	
	public Employee deleteEmployeeById(long id) {
		Employee employee = this.getEmployeeById(id);
		employeeRepository.deleteEmployeeById(id);
		return employee;
	}
	
	// https://www.geeksforgeeks.org/spring-rest-pagination/
	public PageOutput gotoPage(int pageNumber, int pageSize) {
		Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by("empId").ascending());
        Page<Employee> page = employeeRepository.findAll(paging);
        
        PageOutput pageOutput = new PageOutput();
        
        if (page.hasPrevious())
        	pageOutput.setPrevPage(page.previousPageable());
        if (page.hasNext())
        	pageOutput.setNextPage(page.nextPageable());
        
        pageOutput.setPageData(page.getContent());
        
        pageOutput.setPageNumber(pageNumber);
        pageOutput.setPageSize(pageSize);
        
        pageOutput.setTotalPages(page.getTotalPages());
        pageOutput.setTotalElements(page.getTotalElements());
 
        // Retrieve the items
        return pageOutput;
	}
}
