package org.fage.controller;

import java.util.Date;

import org.fage.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author Fapha
 * @date 2017年4月5日下午1:59:01
 * <p>Title: 测试用例</p> 
 * <p>Description:用户控制器类 </p>
 *
 */

@ResponseBody
@RequestMapping("/users")
@Controller
public class UserController {
	
	/**
	 * @return User本身
	 * <p>Description:测试SpringMVC自带的json解析功能<p/>
	 */
	@RequestMapping("/get")
	public User getUser(){
		return new User(3,"fage",new Date());
	}

	/**
	 * <p>Description:Helloworld!<p/>
	 */
	@RequestMapping("/hello")
	public String helloworld(){
		return "helloworld";
	}
	
}
