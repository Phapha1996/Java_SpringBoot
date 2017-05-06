package org.fage.controller;

import java.util.Date;

import org.fage.domain.Department;
import org.fage.domain.User;
import org.fage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author Fapha
 * @date 2017年4月7日上午9:35:30
 * <p>Description: 测试CRUD-Json版本</p>
 *
 */
@RequestMapping("/users")
@Controller
@ResponseBody
public class UserControllerJson{
	@Autowired
	private UserService userService;
	
	
	/**
	 * <p>Description:下面四个方法分别为单个Crud操作<p/>
	 */
	//新增加一个User，无级联的
	@GetMapping("/add")
	public String save(){
		User u = new User();
		u.setUsername("fage");
		u.setPassword("123");
		u.setBirthday(new Date());
		userService.saveByEntity(u);
		return "add_success";
	}
	
	
	@GetMapping(value="/delete")
	public String delete(@RequestParam(name="id") int id){
		userService.deleteById(id);
		return "delete_success";
	}
	
	//可以级联得到Department
	@GetMapping("/get")
	public User get(@RequestParam(name="id")int id){
		return userService.getById(id);
	}
	
	
	@GetMapping("/update")
	public String update(@RequestParam(name="id") int id){
		userService.updateUser(id);
		return "update_success";
	}
	
	@GetMapping("/exception")
	public void testException(){
		throw new RuntimeException("接收到异常啦！！！");
	}
	
	
	/**
	 * <p>Description:测试级联Department操作,数据库中必须有id为1的部门，才能级联<p/>
	 * <p>必须先存储一个部门，然后再调用此方法</p>
	 */
	@GetMapping("/addAnd")
	public String addAnd(){
		
		User u = new User();
		u.setUsername("fage");
		u.setPassword("123");
		u.setBirthday(new Date());
		
		Department d = new Department();
		d.setId(1);
		d.setName("什么部分");
		d.setCreateDate(new Date());
		u.setDepartment(d);
		
		userService.saveByEntity(u);
		return "add_user_department";
	}
	
	
	
}
