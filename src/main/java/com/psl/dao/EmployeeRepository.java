package com.psl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psl.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

//INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, DESIGNATION, DEPARTMENT, SALARY) VALUES(1, 'ABC', 'Software Engineer I', 'Data BFSI', 35000);
//INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, DESIGNATION, DEPARTMENT, SALARY) VALUES(2, 'DEF', 'Software Engineer II', 'Data BFSI', 70000);
//INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, DESIGNATION, DEPARTMENT, SALARY) VALUES(3, 'GHI', 'Software Engineer II', 'Data BFSI', 70000);
//INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, DESIGNATION, DEPARTMENT, SALARY) VALUES(4, 'JKL', 'Architect', 'Data BFSI', 90000);
//INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, DESIGNATION, DEPARTMENT, SALARY) VALUES(5, 'MNO', 'Manager', 'Data BFSI', 75000);
