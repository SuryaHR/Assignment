package com.assignment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.assignment.project.domain.Department;
import com.assignment.project.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartmentDetails(Department deptList) {
		return departmentRepository.save(deptList);
	}

	@Override
	public List<Department> getDepartmentDetails() {
		List<Department> deptList = departmentRepository.findAll();
		return deptList;
	}

	@Override
	public String updateDepartmentDetails(Department deptList) {
		Assert.notNull(deptList, "Department Details Object Cannot be null");
		Assert.notNull(deptList.getId() , "Department Id Cannot be Null");
			if(departmentRepository.existsById(deptList.getId())) {
				departmentRepository.save(deptList);
				return "Department Updated Successfully";
			}
			return "Update not Successfull";
	}

	@Override
	public String deleteDepartmentDetails(long id) {
		departmentRepository.delete(departmentRepository.findById(id).get());
		 return "Department Deleted Successfully";
	}

}
