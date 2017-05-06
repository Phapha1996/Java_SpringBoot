package org.fage.service;

import org.fage.domain.Department;
import org.fage.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void addDepartment(Department d){
		departmentRepository.save(d);
	}
}
