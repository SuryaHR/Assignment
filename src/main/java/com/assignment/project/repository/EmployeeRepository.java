package com.assignment.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartmentId(long departmentId);

}
