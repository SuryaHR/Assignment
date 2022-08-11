package com.assignment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.assignment.project.domain.Professor;
import com.assignment.project.repository.ProfessorRepository;

@Service
public class ProfessorServiceImp implements ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public Professor saveProfessorDetails(Professor professorList) {
		return professorRepository.save(professorList);
	}

	@Override
	public List<Professor> getProfessorByDepartmentId(long departmentId) {
		List<Professor> professor = professorRepository.findByDepartmentId(departmentId);
		return professor;
	}

	@Override
	public String updateProfessorDetails(Professor professorList) {
		Assert.notNull(professorList, "Professor Details Object Cannot be null");
		Assert.notNull(professorList.getId() , "Professor Id Cannot be Null");
			if(professorRepository.existsById(professorList.getId())) {
				professorRepository.save(professorList);
				return "Professor Updated Successfully";
			}
			return "Update not Successfull";
	}

	@Override
	public String deleteProfessorDetails(long id) {
		professorRepository.delete(professorRepository.findById(id).get());
		 return "Professor Deleted Successfully";
	}

}
