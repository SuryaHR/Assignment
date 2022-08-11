package com.assignment.project.service;

import java.util.List;

import com.assignment.project.domain.Employee;

public interface EmployeeService {

	Employee saveEmployeeDetails(Employee employeeList);

	List<Employee> getEmployeeByDepartmentId(long departmentId);

	String updateEmployeeDetails(Employee employeeList);

	String deleteEmployeeDetails(long id);

}
