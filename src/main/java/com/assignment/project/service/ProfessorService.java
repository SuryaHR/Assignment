package com.assignment.project.service;

import java.util.List;

import com.assignment.project.domain.Professor;

public interface ProfessorService {

	Professor saveProfessorDetails(Professor professorList);

	List<Professor> getProfessorByDepartmentId(long departmentId);

	String updateProfessorDetails(Professor professorList);

	String deleteProfessorDetails(long id);

}
