package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department createDepartment(@RequestBody Department departments) {
	Department savedDepartment = departmentService.createDepartment(departments);
		
		return savedDepartment;
	}

	@GetMapping("/departments/{id}")
	public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
	Optional<Department> fetchedData = departmentService.getDepartmentById(departmentId);
		
	return fetchedData;
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartmentInfo(){
	List<Department> fetchAllData = departmentService.getAllDepartmentInfo();
		
		return fetchAllData;
	}
	
	@PutMapping("/update/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department ) {
	Department updatedDepartment = departmentService.updateDepartmentById(departmentId, department);
	
		return updatedDepartment;
	}
	
	@DeleteMapping("/delete/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
	  departmentService.deleteDepartmentById(departmentId);
		
		return "Data Deleted Successfully !";
	}
}
