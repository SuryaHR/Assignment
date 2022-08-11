package com.assignment.project.service;

import java.util.List;

import com.assignment.project.domain.Department;

public interface DepartmentService {

	Department saveDepartmentDetails(Department deptList);

	List<Department> getDepartmentDetails();

	String updateDepartmentDetails(Department deptList);

	String deleteDepartmentDetails(long id);

}
