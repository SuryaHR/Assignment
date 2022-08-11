package com.assignment.project.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.domain.Department;
import com.assignment.project.service.DepartmentService;

@CrossOrigin(origins = "*" , maxAge = 3600 , allowedHeaders = "*")
@RestController
@RequestMapping("/api/department")
public class DepartmentEndpoint {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save/department")
	public Department save(@RequestBody Department deptList) {
		return departmentService.saveDepartmentDetails(deptList);
	}
	
	@GetMapping("/get/department")
	public ResponseEntity<List<Department>> getDepartments(){
		return ResponseEntity.ok(departmentService.getDepartmentDetails());
	}
	
	@PutMapping("/update/department")
	public String update(@RequestBody Department deptList) {
		return departmentService.updateDepartmentDetails(deptList);
	}
	
	@DeleteMapping("/delete/department")
	public String delete(@RequestParam("id") long id) {
		departmentService.deleteDepartmentDetails(id);
		return "Department Deleted Successfully";
	}
}
