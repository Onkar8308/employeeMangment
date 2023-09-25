package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import javax.persistence.PersistenceUnit;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.error.GlobalException;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

import lombok.NonNull;
import lombok.val;

@RestController // http://localhost:8080/
@CrossOrigin(origins =  "http://localhost:4200")
public class EmployeeApi {

	@Autowired
	private EmployeeService empservice;

	// get all employee
	@GetMapping("/getAllEmployee")
	public List<Employee> getEmployee() {
		return empservice.getAllEmployee();
	}

	// Save employee
	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp)  {
		Employee employee = empservice.addEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}

	// update employee by name
	@PutMapping("/updateEmployeeByName/{empId}/{newEmpName}")
	public ResponseEntity<Employee> updateEmployeeByName(@Valid @PathVariable("empId") Integer id,
			@Valid @PathVariable("newEmpName") String newEmpName) throws GlobalException {

		Employee emp = empservice.updateEmployeeByName(newEmpName, id);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);

	}

	// delete employee
	@DeleteMapping("/deleteEmployeeById/{empId}")
	public ResponseEntity<String> deleteEmployee(@Valid @Min(1) @Max(2) @PathVariable("empId") Integer id) throws GlobalException {
		String msg =  empservice.deleteEmployee(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);

	}

	// update employee by age
	@PutMapping("/updateEmployeeByAge/{empId}/{newEmpAge}")
	public ResponseEntity<Employee> updateEmployeeByAge(@PathVariable("empId") Integer id, @PathVariable("newEmpAge") Integer newEmpAge)
			throws GlobalException {
		Employee upatedEmployee =  empservice.updateEmployeeByAge(newEmpAge, id);
		return new ResponseEntity<Employee>(upatedEmployee,HttpStatus.OK);
	}

	// update employee emailId
	@PutMapping("/updateEmployeeEmail/{empId}/{newEmail}")
	public ResponseEntity<Employee> updateEmployeeEmail(@PathVariable("empId") Integer id, @PathVariable("newEmail") String newEmail)
			throws GlobalException {
		Employee updatedEmployee = empservice.updateEmployeeEmail(newEmail, id);
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
	}

	// delete All employee
	@DeleteMapping("/deleteAllEmployee")
	public ResponseEntity<String> deleteAllEmployee() throws GlobalException {
		String msg =  empservice.deleteAllEmployee();
		return new ResponseEntity<String>(msg,HttpStatus.OK);

	}

	// find employee by name
	@GetMapping("/findEmployeebyName/{name}")
	public ResponseEntity<List<Employee>> findEmployeeByName(
			@PathVariable("name") @NotBlank(message = "not blank")  String employeename) throws GlobalException {

		List<Employee> lst = empservice.findEmployeeByName(employeename);
		if (lst.isEmpty())
			throw new GlobalException("employee with name:" + employeename + " not exist");
		else
			return new ResponseEntity<List<Employee>>(lst,HttpStatus.FOUND);

	}

	// find employee by name
	@GetMapping("/findEmployeebyAge/{empAge}")
	public ResponseEntity<List<Employee>> findEmployeeByAge(@PathVariable("empAge") Integer empAge) throws GlobalException {

		List<Employee> employeeWitAge =  empservice.findEmployeeByAge(empAge);
		if (employeeWitAge.isEmpty())
			throw new GlobalException("employee with Age:" + empAge + " not exist");
		else
			return new ResponseEntity<List<Employee>>(employeeWitAge,HttpStatus.FOUND);

	}

	@GetMapping("/findEmployeebyEmail/{email}")
	public ResponseEntity<List<Employee>> findEmployeeByEmail(@Valid @NotNull @PathVariable("email") String email) throws GlobalException {

		List<Employee> employee =  empservice.findEmployeeByemployeeemail(email);
		
		if (employee.isEmpty())
			throw new GlobalException("employee with Email:" + email + " not exist");
		else
			return new ResponseEntity<List<Employee>>(employee,HttpStatus.FOUND);


	}

	@GetMapping("/findByemailOrName/{employeeemail}/{name}")
	public List<Employee> findByEmployeeemailOrName(@PathVariable("employeeemail") String employeeemail,
			@PathVariable("name") String name) throws GlobalException {

		return empservice.findByEmployeeemailOrName(employeeemail, name);

	}

	@GetMapping("/getEmployeeBetAge/sAge/{sAge}/eAge/{eAge}")
	public List<Employee> getEmployeeBetAge(@PathVariable("sAge") int sAge, @PathVariable("eAge") int eAge) {
		return empservice.getEmployeeBetAge(sAge, eAge);

	}

	@GetMapping("/getEmployeeBetEmployeeDob/sdate/{sDate}/eDate/{eDate}")
	public List<Employee> getEmployeeBetEmployeeDob(@PathVariable("sDate") Date sDate,
			@PathVariable("eDate") Date eDate) {
		return empservice.getEmployeeBetEmployeeDob(sDate, eDate);

	}

	@PutMapping("/employeeassigndepartment/{empid}/department/{deptid}")
	public Employee employeeAssignDepartment(@PathVariable Integer empid, @PathVariable Integer deptid) {
		return empservice.employeeAssignDepartment(empid, deptid);
	}
	
	//using @transactional and @modify
	@PutMapping("/updateEmployeeByName1/{name}/{id}")
	public Employee updateEmployeeByName1(@PathVariable String name,@PathVariable Integer id) throws GlobalException {
		return empservice.updateEmployeeByName1(name,id);
		
	}
	
	@PutMapping("/updateEmployeeByAge1/{age}/{id}")
	public Employee updateEmployeeBySalary1(@PathVariable Integer age,@PathVariable Integer id ) throws GlobalException {
		return empservice.updateEmployeeBySalary1(age,id);
		
	}
	
	
	@DeleteMapping("/deleteEmployeeById1/{id}")
	public String deleteEmployeeById1(@PathVariable("id") Integer id) throws GlobalException {
		return empservice.deleteEmployeeById1(id);
		
	}
	

	@DeleteMapping("/deleteEmployeeByEmail1/{email}")
	public String deleteEmployeeByEmail1(@PathVariable String email) throws GlobalException {
		return empservice.deleteEmployeeByEmail1(email);
		
	}
	
	@GetMapping("/getEmployeeDepartment/{empid}")
	public Department getEmployeeDepartment(@PathVariable("empid") Integer id) {
		return empservice.getEmployeeDepartment(id);
		
	}
}
