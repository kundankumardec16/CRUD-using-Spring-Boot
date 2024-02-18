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

@Repository
public class EmployeeDAO {
	
//	private List<Employee> employees;
//
//	public EmployeeDAO() {
//		super();
//		this.employees = new ArrayList<Employee>();
//		
//		employees.add(new Employee(1L, "ABC", "Software Engineer I", "Data BFSI", 35000L));
//		employees.add(new Employee(2L, "DEF", "Software Engineer II", "Data BFSI", 70000L));
//		employees.add(new Employee(3L, "GHI", "Software Engineer II", "Data BFSI", 70000L));
//		employees.add(new Employee(4L, "JKL", "Architect", "Data BFSI", 90000L));
//		employees.add(new Employee(5L, "MNO", "Manager", "Data BFSI", 75000L));
//	}
//	
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//	
//	public Employee getEmployeeById(long id) {
//		for (Employee emp : employees) {
//			if (emp.getEmpId() == id) {
//				return emp;
//			}
//		}
//		
//		return null;
//	}
//	
//	public Employee addEmployee(Employee employee) {
//		employees.add(employee);
//		return employee;
//	}
//	
//	public Employee editEmployeeById(long id, Employee employee) {
//		for (Employee emp : employees) {
//			if (emp.getEmpId() == id) {
//				if (employee.getEmpName() != null) {
//					emp.setEmpName(employee.getEmpName());
//				}
//				
//				if (employee.getDesignation() != null) {
//					emp.setDesignation(employee.getDesignation());
//				}
//				
//				if (employee.getDepartment() != null) {
//					emp.setDepartment(employee.getDepartment());
//				}
//				
//				if (employee.getSalary() != null) {
//					emp.setSalary(employee.getSalary());
//				}
//				
//				return emp;
//			}
//		}
//		
//		return null;
//	}
//	
//	public Employee deleteEmployeeById(long id) {
//		int idx = -1;
//		Employee emp = null;
//		
//		for (int i = 0 ; i < employees.size() ; i++) {
//			if (employees.get(i).getEmpId() == id) {
//				idx = i;
//				emp = employees.get(i);
//				break;
//			}
//		}
//		
//		if (idx != -1) {
//			employees.remove(idx);
//		}
//		
//		return emp;
//	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// https://www.geeksforgeeks.org/spring-boot-h2-database/
	@Async
	public CompletableFuture<List<Employee>> getEmployees() {
		return CompletableFuture.completedFuture(employeeRepository.findAll());
	}
//	public Future<List<Employee>> getEmployees() {
//		return  new AsyncResult<List<Employee>>(employeeRepository.findAll());
//	}
	
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee editEmployeeById(long id, Employee employee) {
		Employee emp = this.getEmployeeById(id);
		
		if (employee.getEmpName() != null) {
			emp.setEmpName(employee.getEmpName());
		}
		
		if (employee.getDesignation() != null) {
			emp.setDesignation(employee.getDesignation());
		}
		
		if (employee.getDepartment() != null) {
			emp.setDepartment(employee.getDepartment());
		}
		
		if (employee.getSalary() != null) {
			emp.setSalary(employee.getSalary());
		}
		
		return employeeRepository.save(emp);
	}
	
	public Employee deleteEmployeeById(long id) {
		Employee employee = this.getEmployeeById(id);
		employeeRepository.deleteById(id);
		return employee;
	}
	
	// https://www.geeksforgeeks.org/spring-rest-pagination/
	public List<Employee> getPage(int pageNumber) {
		Pageable paging = PageRequest.of(pageNumber, 2, Sort.by("empId").ascending());
        Page<Employee> page = employeeRepository.findAll(paging);
 
        // Retrieve the items
        return page.getContent();
	}
}
