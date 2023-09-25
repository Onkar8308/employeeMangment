package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getAllDepartment();

}
