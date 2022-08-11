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

import com.assignment.project.domain.Employee;
import com.assignment.project.domain.Professor;
import com.assignment.project.service.ProfessorService;

@CrossOrigin(origins = "*" , maxAge = 3600 , allowedHeaders = "*")
@RestController
@RequestMapping("/api/professor")
public class ProfessorEndpoint {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save/professor")
	public Professor save(@RequestBody Professor professorList) {
		return professorService.saveProfessorDetails(professorList);
	}
	
	@GetMapping("/get/professor")
	public ResponseEntity<List<Professor>> getProfessor(@RequestParam("departmentId") long departmentId){
		return ResponseEntity.ok(professorService.getProfessorByDepartmentId(departmentId));
	}
	
	@PutMapping("/update/professor")
	public String update(@RequestBody Professor professorList) {
		return professorService.updateProfessorDetails(professorList);
	}
	
	@DeleteMapping("/delete/professor")
	public String delete(@RequestParam("id") long id) {
		professorService.deleteProfessorDetails(id);
		return "Professor Deleted Successfully";
	}
}
