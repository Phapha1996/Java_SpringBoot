package com.glut.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.glut.domain.User;
import com.glut.user.controller.UserController;
import com.glut.user.service.UserService;
/**
 * 
 * @author Caizhf
 * @date 2017年4月24日下午6:23:59
 * @version v.0.1
 * <p>Description: 测试User类</p>
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserController uc;
	@Autowired
	private UserService us;
	
	
	
	//测试Controller层注册
	@Test
	public void testRegister(){
		User user = new User();
		user.setNickname("fage");
		user.setBirthday(new Date());
		uc.register(user);
	}
	
	
	//测试在Service层删除
	@Test
	public void testServiceDelete(){
		us.delete(2);
	}
	
	
	
}
