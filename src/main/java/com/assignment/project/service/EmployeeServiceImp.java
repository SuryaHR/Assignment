package com.assignment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.assignment.project.domain.Employee;
import com.assignment.project.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeDetails(Employee employeeList) {
		return employeeRepository.save(employeeList);
	}

	@Override
	public List<Employee> getEmployeeByDepartmentId(long departmentId) {
		List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
		return employees;
	}

	@Override
	public String updateEmployeeDetails(Employee employeeList) {
		Assert.notNull(employeeList, "Employee Details Object Cannot be null");
		Assert.notNull(employeeList.getId() , "Employee Id Cannot be Null");
			if(employeeRepository.existsById(employeeList.getId())) {
				employeeRepository.save(employeeList);
				return "Employee Updated Successfully";
			}
			return "Update not Successfull";
			
	}

	@Override
	public String deleteEmployeeDetails(long id) {
		employeeRepository.delete(employeeRepository.findById(id).get());
		 return "Employee Deleted Successfully";
	}
	
}
