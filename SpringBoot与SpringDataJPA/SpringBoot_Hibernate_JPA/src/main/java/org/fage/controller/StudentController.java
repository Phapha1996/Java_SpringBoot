package org.fage.controller;

import java.util.Iterator;
import java.util.List;

import org.fage.domain.Student;
import org.fage.service.Stu_GraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	private Stu_GraService s_gService;
	
	/**
	 * 
	 * @return
	 * <p>Description:Junit的这个方法有no session异常，而在web环境下就没有这个异常<p/>
	 */
	@RequestMapping("/gets")
	public String getScoStu(){
		List<Student> students = s_gService.getGradeStus("软件2014-1班");
		Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
		return "success";
	}
}
