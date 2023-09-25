package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.error.GlobalException;
import com.example.demo.repo.DepartmentRepository;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();

	}

	public Employee updateEmployeeByName(String newEmpName, Integer id) throws GlobalException {
		Optional<Employee> obj = empRepo.findById(id);
		// TODO Auto-generated method stub
		if (!obj.isPresent()) {
			throw new GlobalException("Employee not exist");
		} else {
			Employee employee = empRepo.findById(id).get();
			employee.setName(newEmpName);
			empRepo.save(employee);
			return employee;
		}

	}

	@Override
	public String deleteEmployee(Integer id) throws GlobalException {
		Optional<Employee> obj = empRepo.findById(id);
		if (!obj.isPresent()) {
			throw new GlobalException("Employee by id:" + id + " not exist");
		} else {
			empRepo.deleteById(id);
			return "Employee with id "+id+" deleted succefully";
		}

	}

	@Override
	public Employee updateEmployeeByAge(Integer newEmpAge, Integer id) throws GlobalException {
		Optional<Employee> obj = empRepo.findById(id);

		if (!obj.isPresent()) {
			throw new GlobalException("Employee not exist");
		} else {
			Employee employee = empRepo.findById(id).get();
			employee.setEmployeeage(newEmpAge);
			empRepo.save(employee);
			return employee;
		}

	}

	@Override
	public Employee updateEmployeeEmail(String newEmail, Integer id) throws GlobalException {
		Optional<Employee> obj = empRepo.findById(id);
		if (!obj.isPresent()) {
			throw new GlobalException("Employee not exist");
		} else {
			Employee employee = empRepo.findById(id).get();
			employee.setEmployeeemail(newEmail);
			empRepo.save(employee);
			return employee;
		}

	}

	@Override
	public String deleteAllEmployee() throws GlobalException {
		// TODO Auto-genJUYerated method stub
		List<Employee> obj = empRepo.findAll();
		if (obj.isEmpty()) {
			throw new GlobalException("No employee is presesnt");
		} else {
			empRepo.deleteAll();
			return "All Employees deleted";
		}

	}

	@Override
	public List<Employee> findEmployeeByName(String employeename) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeeByname(employeename);

	}

	@Override
	public List<Employee> findEmployeeByAge(Integer empAge) throws GlobalException {
		// TODO Auto-generated method stub
		List<Employee> list = empRepo.findEmployeeByemployeeage(empAge);
		if (list.isEmpty())
			throw new GlobalException("employee with age:" + empAge + " not exist");
		else
			return list;
	}

	@Override
	public Employee employeeAssignDepartment(Integer empid, Integer deptid) {
		// TODO Auto-generated method stub
		Employee emp = empRepo.findById(empid).get();
		Department dept = deptRepo.findById(deptid).get();
		emp.employeeAssignDepartment(dept);
		return empRepo.save(emp);

	}

	@Override
	public List<Employee> findEmployeeByemployeeemail(String email) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeeByemployeeemail(email);
	}

	@Override
	public List<Employee> findByEmployeeemailOrName(String employeeemail, String name) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeemailOrName(employeeemail, name);
	}

	@Override
	public List<Employee> getEmployeeBetAge(int sAge, int eAge) {
		// TODO Auto-generated method stub

		return empRepo.getEmployeeBetAge(sAge, eAge);
	}

	@Override
	public List<Employee> getEmployeeBetEmployeeDob(Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return empRepo.getEmployeeBetEmployeeDob(sDate, eDate);
	}

	@Override
	public Employee updateEmployeeByName1(String name, Integer id) throws GlobalException {
		// TODO Auto-generated method stub
		int value = empRepo.updateEmployeeByName1(name, id);
		if (value > 0) {
			return empRepo.findById(id).get();
		} else {
			throw new GlobalException("no employee exist");
		}
	}

	@Override
	public Employee updateEmployeeBySalary1(Integer age, Integer id) throws GlobalException {
		// TODO Auto-generated method stub
		int value = empRepo.updateEmployeeBsySalary1(age, id);
		if (value > 0) {
			return empRepo.findById(id).get();
		} else {

			throw new GlobalException(id + " not found for updation");
		}
	}

	@Override
	public String deleteEmployeeById1(Integer id) throws GlobalException {
		// TODO Auto-generated method stub
		int value = empRepo.deleteEmployeeById1(id);
		if (value > 0) {
			return value + " employee deleteed";
		} else {
			throw new GlobalException("employee with id  " + id + " not exist");
		}
	}

	@Override
	public String deleteEmployeeByEmail1(String email) throws GlobalException {
		// TODO Auto-generated method stub
		int value = empRepo.deleteEmployeeByEmail1(email);
		if (value > 0)
			return "employee deleted";
		else
			throw new GlobalException("employee with email  " + email + " not exist");

	}

	@Override
	public Department getEmployeeDepartment(Integer id) {
		// TODO Auto-generated method stub
		Department value = empRepo.getEmployeeDept(id);
		return value;
	}

}