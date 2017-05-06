package com.glut.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glut.domain.User;
import com.glut.user.service.UserService;
/**
 * 
 * 
 * @author Caizhf
 * @date 2017年4月24日下午4:44:19
 * @version v.0.1
 * <p>Description: User板块Controller测试类</p>
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @param user
	 * <p>Description:测试简单注册功能<p/>
	 * <p>测试路径：http://127.0.0.1:8080/enroll/users/signin?nickname=fage&birthday=1996-1-1</p>
	 */
	@GetMapping("/signin")
	public String register(User user){
		logger.info(user.getNickname()+"尝试注册");
		userService.saveOrUpdate(user);
		logger.info(user.getNickname()+"注册成功!");
		return "success";
	}
	
	/**
	 * 
	 * @param id
	 * <p>Description:测试简单登录功能<p/>
	 * <p>测试路径:http://127.0.0.1:8080/enroll/users/login/1</p>
	 */
	@RequestMapping("/login/{id}")
	public User login(@PathVariable int id){
		logger.info("尝试登录id="+id+"用户");
		return userService.findById(id);
	}
	
}
