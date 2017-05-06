package org.fage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Fapha
 * @date 2017年4月8日下午8:23:19
 * @version v1.0.1
 * <p>Title: 测试使用thymeleaf模板</p> 
 * <p>Description: User模板类</p>
 *
 */
@Controller
@RequestMapping
public class UserControllerTemplate {
	
	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("hahhaa");
		return "hello";
	}
}
