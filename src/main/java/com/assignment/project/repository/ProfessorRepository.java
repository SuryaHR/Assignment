package com.assignment.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	List<Professor> findByDepartmentId(long departmentId);

}
