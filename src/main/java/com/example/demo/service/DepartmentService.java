package com.example.demo.service;

import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department createDepartment(Department departments) {
	Department savedDepartment = departmentRepository.save(departments);
	logger.info("Department Was Created Successfully for : {} " , savedDepartment.getDepartmentName());	
	
		return savedDepartment;
	}
	
	public Optional<Department> getDepartmentById(Long departmentId) {
	Optional<Department> fetchedData = departmentRepository.findById(departmentId);
	logger.info("The Deaprtment Data was Fetched Successfully : {} " , fetchedData.toString());
		
		return fetchedData;
	}
	
	
	public List<Department> getAllDepartmentInfo(){
	List<Department> fetchAllData = departmentRepository.findAll();
		logger.info("Successfully fetched All the Department Data : {} " , fetchAllData);
		
		return fetchAllData;
	}
	
	
	public Department updateDepartmentById(Long departmentId, Department department) {
	Department existedDepartment = departmentRepository.findById(departmentId).orElse(null);
	    if(existedDepartment != null) {
	    	existedDepartment.setDepartmentName(department.getDepartmentName());
	    	existedDepartment.setDepartmentAddress(department.getDepartmentAddress());
	    	existedDepartment.setDepartmentCode(department.getDepartmentCode());
	    Department updatedData = departmentRepository.save(existedDepartment);
	    	
	    	logger.info("Department was updated Successfully : {} " , updatedData.getDepartmentName());
	    	return updatedData;
	    }
		
		return null;
	}
	
	public void deleteDepartmentById(Long departmentId) {
	 departmentRepository.deleteById(departmentId);
	  
	}
	
}
