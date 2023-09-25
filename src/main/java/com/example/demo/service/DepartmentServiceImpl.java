package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Department;
import com.example.demo.repo.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepo.save(department);

	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll();
	}

}
