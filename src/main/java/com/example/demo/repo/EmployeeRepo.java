package com.example.demo.repo;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findEmployeeByname(String name);

	List<Employee> findEmployeeByemployeeage(Integer empAge);

	List<Employee> findEmployeeByemployeeemail(String email);
	
	
	List<Employee> findByEmployeeemailOrName(String employeeemail,String name);

	@Query(value = "select * from employee where employeeage between ?1 and ?2",nativeQuery = true)
	List<Employee> getEmployeeBetAge(int sAge, int eAge);
	
	@Query(value = "select * from employee where employe_dob between ?1 and ?2",nativeQuery = true)
	List<Employee> getEmployeeBetEmployeeDob(Date sAge, Date eAge);

	
	@Transactional
	@Modifying
	@Query(value = "update Employee set name = ?1 where employeeid = ?2")
	int updateEmployeeByName1(String name, int id);

	
	@Transactional
	@Modifying
	@Query(value = "update Employee set employeeage = ?1 where employeeid = ?2")
	int updateEmployeeBsySalary1(Integer age, Integer id);

	@Transactional
	@Modifying
	@Query(value = "delete Employee where employeeid = ?1")
	int deleteEmployeeById1(Integer id);

	@Transactional
	@Modifying
	@Query(value = "delete Employee where employeeemail = ?1")
	int deleteEmployeeByEmail1(String email);
	
	
	@Query(value = "select dept from Employee where employeeid =?1")
	Department getEmployeeDept(Integer id);
}
