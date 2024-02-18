package com.psl.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.dao.EmployeeDAO;
import com.psl.employee.Employee;

@RestController
public class HomeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Cacheable(value = {"employees"})
	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		// Deprecated
		// Future<List<Employee>> future = employeeDAO.getEmployees();
		CompletableFuture<List<Employee>> future = employeeDAO.getEmployees();
		
		try {
			return future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Cacheable(value = "employee", key = "#id")
	@GetMapping(value = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return employeeDAO.getEmployeeById(id);
	}
	
	@Caching(
		put = {
			@CachePut(cacheNames = {"employee"}, key = "#employee.getEmpId")
		},
		evict = {
			@CacheEvict(value = "employees", allEntries = true)
		}
	)
	@PostMapping(value = "employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeDAO.addEmployee(employee);
	}
	
	@Caching(
		evict = {
			@CacheEvict(value = "employee", key = "#id"), 
			@CacheEvict(value = "employees", allEntries = true)
		},
		put = {
			@CachePut(cacheNames = {"employee"}, key = "#id")
		}
	)
	@PutMapping(value = "employee/{id}")
	public Employee editEmployeeById(@PathVariable long id, @RequestBody Employee employee) {
		return employeeDAO.editEmployeeById(id, employee);
	}
	
	@Caching(
		evict = {
			@CacheEvict(value = "employee", key = "#id"), 
			@CacheEvict(value = "employees", allEntries = true)
		}
	)
	@DeleteMapping(value = "/employee/{id}")
	public Employee deleteEmployeeById(@PathVariable long id) {
		return employeeDAO.deleteEmployeeById(id);
	}
}
