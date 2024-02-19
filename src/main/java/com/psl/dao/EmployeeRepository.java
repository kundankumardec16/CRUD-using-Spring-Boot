package com.psl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.psl.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT EMP_ID, EMP_NAME, EMP_EMAIL, EMP_DOB, EMP_DESIGNATION, EMP_DEPARTMENT, EMP_SALARY, IS_ACTIVE FROM EMPLOYEE WHERE IS_ACTIVE = TRUE")
	public List<Employee> getAllEmployees();
	
	@Query(nativeQuery = true, value = "SELECT EMP_ID, EMP_NAME, EMP_EMAIL, EMP_DOB, EMP_DESIGNATION, EMP_DEPARTMENT, EMP_SALARY, IS_ACTIVE FROM EMPLOYEE WHERE IS_ACTIVE = TRUE AND EMP_ID = :id")
	public Employee getEmployeeById(@Param("id") long id);
	
//	@Transactional
//	@Modifying
//	@Query(nativeQuery = true, value = "INSERT INTO EMPLOYEE (EMP_NAME, EMP_EMAIL, EMP_DOB, EMP_DESIGNATION, EMP_DEPARTMENT, EMP_SALARY, IS_ACTIVE) VALUES (:#{#emp.getEmpName()}, :#{#emp.getEmpEmail()}, :#{#emp.getEmpDob()}, :#{#emp.getEmpDesignation()}, :#{#emp.getEmpDepartment()}, :#{#emp.getEmpSalary()}, TRUE)")
//	public void insertRecord(@Param("emp") Employee emp);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE EMPLOYEE SET IS_ACTIVE = FALSE WHERE EMP_ID = :id")
	public void deleteEmployeeById(@Param("id") long id);
}