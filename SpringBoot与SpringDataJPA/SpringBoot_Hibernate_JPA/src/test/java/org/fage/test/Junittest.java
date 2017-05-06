package org.fage.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.fage.domain.Grade;
import org.fage.domain.Student;
import org.fage.service.Stu_GraService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Junittest {
	@Autowired
	private Stu_GraService s_gService;
	
	
	//测试为一个新的班级添加这些学生
	@Test
	public void testRegisterStudent(){
		Student s1 = new Student("蔡智法",93,new Date());
		Student s2 = new Student("蔡小发",80,new Date());
		Student s3 = new Student("蔡大发",60,new Date());
		Student s4 = new Student("蔡志发",59,new Date());
		Student s5 = new Student("蔡美玲",91,new Date());
		Student s6 = new Student("卢艳玲",88,new Date());
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		
		Grade grade = new Grade("软件2014-1班",new Date());
		
		s_gService.registerStudent(grade, students);
	}
	
	//新增一堆的班级
	@Test
	public void testAddManyGrade(){
		Grade g1 = new Grade("计算机14-1班",new Date());
		Grade g2 = new Grade("计算机14-2班",new Date());
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(g1);
		grades.add(g2);
		s_gService.addGrades(grades);
	}
	
	
	//根据班级名字来查询学生，连接查询，请注意，踩过Object坑，查询语句要标准
	@Test
	public void testGet_Stu_By_GraName(){
		List<Student> students = s_gService.getGradeStus("软件2014-1班");
		Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
	}
	
	
/*	@Test
	专门用来测试事务的一致性的方法
	public void testTransaction(){
		s_gService.addGrade(new Grade("软件2014-2班",new Date()));
	}
*/	
	//测试cache
	@Test
	public void testCache(){
		Grade g = s_gService.getGradeByName("软件2014-1班");
		System.out.println(g.getName());
		Grade g2 = s_gService.getGradeByName("软件2014-1班");
		System.out.println(g2.getName());
	}
}
