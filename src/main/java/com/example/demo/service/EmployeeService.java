package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.error.GlobalException;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);

	public List<Employee> getAllEmployee();

	public Employee updateEmployeeByName(String newEmpName, Integer id)throws GlobalException;

	public String deleteEmployee(Integer id)throws GlobalException;

	public Employee updateEmployeeByAge(Integer newEmpAge, Integer id)throws GlobalException ;

	public Employee updateEmployeeEmail(String newEmail, Integer id) throws GlobalException;

	public String deleteAllEmployee()throws GlobalException;

	public List<Employee> findEmployeeByName(String employeename)throws GlobalException;

	public List<Employee> findEmployeeByAge(Integer empAge)throws GlobalException;

	public Employee employeeAssignDepartment(Integer empid, Integer deptid);

	public List<Employee> findEmployeeByemployeeemail(String email);

	public List<Employee> findByEmployeeemailOrName(String email, String empName);

	public List<Employee> getEmployeeBetAge(int sAge, int eAge);

	public List<Employee> getEmployeeBetEmployeeDob(Date sDate, Date eDate);

	//using JPQL query
	public Employee updateEmployeeByName1(String name, Integer id) throws GlobalException;

	public Employee updateEmployeeBySalary1(Integer age, Integer id) throws GlobalException;

	public String deleteEmployeeById1(Integer id) throws GlobalException;

	public String deleteEmployeeByEmail1(String email) throws GlobalException;

	public Department getEmployeeDepartment(Integer id);
	
	}
