package com.assignment.project.endpoint;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

import com.assignment.project.domain.Employee;
import com.assignment.project.service.EmployeeService;

@CrossOrigin(origins = "*" , maxAge = 3600 , allowedHeaders = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeEndpoint {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public Employee save(@RequestBody Employee employeeList) {
		return employeeService.saveEmployeeDetails(employeeList);
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getEmployee(@RequestParam("departmentId") long departmentId){
		return ResponseEntity.ok(employeeService.getEmployeeByDepartmentId(departmentId));
	}
	
	@PutMapping("/updateEmployee")
	public String update(@RequestBody Employee employeeList) {
		return employeeService.updateEmployeeDetails(employeeList);
	}
	
	@DeleteMapping("/deleteEmployee")
	public String delete(@RequestParam("id") long id) {
		employeeService.deleteEmployeeDetails(id);
		return "Employee Deleted Successfully";
	}
	
}
