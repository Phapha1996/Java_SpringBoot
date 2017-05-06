package org.fage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.fage.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * SpringMVC前端与Controller互传
 * @author Administrator
 * @Discription
 * <a href="http://www.icoolxue.com/album/show/39">SpringMVC</a>
 * 
 */
@Controller
@RequestMapping("/")
public class UserController {
	
	/*
	  前端给Controller传值
	  如果加了RequestParam就必须要传值，如果不加就随意
	 */
	@RequestMapping("/login")
	public String login(@RequestParam("user")String user){
//		System.out.println(user.getUsername()+'\n'+user.getPassword());
		System.out.println(user);
		return "success";
	}
	
	//测试值传回
	@RequestMapping("/value")
	public String getValue(@RequestParam("name")String name,Model model){
		//前端用Spring叶子模板显示
		model.addAttribute("name",name);
		return "success";
	}
	
	
	/**
	 * 
	 * @param model
	 * @return 映射到show1模板，在show1中取值user
	 * <p>Description:<p/>
	 */
	@RequestMapping("/thymeleaf")
	public String helloThymeleaf(Model model){
		model.addAttribute("user",new User("fage","123"));
		return "show01";
	}
	
	
	@RequestMapping("/list")
	public String list(Model model){
		List<User> list = new ArrayList<User>();
		list.add(new User("fage","123"));
		list.add(new User("doudou","456"));
		list.add(new User("mama","789"));
		list.add(new User("wife","123"));
		list.add(new User("gaga","123"));
		model.addAttribute("users",list);
		return "show02";
	}
	
}
