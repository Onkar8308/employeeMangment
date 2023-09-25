package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Department;
import com.example.demo.service.DepartmentService;


@RestController

public class DepartmentController {
	@Autowired
	private DepartmentService departmentService; // http://localhost:8990/saveDepartment

	@PostMapping("/saveDepartment") // departmentname and deparmentlocation
	ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
		  Department dept = departmentService.saveDepartment(department);
		 return new ResponseEntity<Department>(dept,HttpStatus.OK);

	}

	@GetMapping("/getDaprtment")
	public List<Department> getAllDepartment() {
	return	departmentService.getAllDepartment();
	}
}
