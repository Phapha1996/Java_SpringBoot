package org.fage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fage.domain.Department;
import org.fage.domain.User;
import org.fage.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Fapha
 * @date 2017年4月11日下午2:30:34
 * @version v.0.1
 * <p>Description: 为了测试一对多用的用例</p>
 *
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 
	 * <p>Description:测试增加单个实体<p/>
	 */
	@RequestMapping("/add")
	public String save(){
		departmentService.addDepartment( new Department("纪检部",new Date()));
		return "success";
	}
	
	
	/**
	 * <p>Description:测试级联，增加一个部门，并且这个部门有很多员工<p/>
	 */
	@GetMapping("/many")
	public String saveMany(){
		Department d = new Department("纪检部",new Date());
		User u1 = new User("u1","123",new Date());
		User u2 = new User("u2","123",new Date());
		User u3 = new User("u3","123",new Date());
		
		u1.setDepartment(d);
		u2.setDepartment(d);
		u3.setDepartment(d);
		
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		d.setUsers(users);
		
		departmentService.addDepartment(d);
		return "list_success";
	}
}
