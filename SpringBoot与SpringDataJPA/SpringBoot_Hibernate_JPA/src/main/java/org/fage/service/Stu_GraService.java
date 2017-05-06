package org.fage.service;


import java.util.List;

import org.fage.domain.Grade;
import org.fage.domain.Student;
import org.fage.repository.GradeRepository;
import org.fage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Caizhf
 * @date 2017年4月25日下午3:10:46
 * @version v.0.1
 * <p>Description: Grade与Student共同的业务类</p>
 *
 */
@Service
@Transactional
public class Stu_GraService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private GradeRepository gradeRepository;
	/*@Autowired
	private LogRepository logRepository;
	*/
	/**
	 * 
	 * @param grade
	 * @param students
	 * <p>Description:为新的班级注册新的学生<p/>
	 */
	@Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.REQUIRED)
	public void registerStudent(Grade grade,List<Student> students){
		if(null==grade)
			throw new RuntimeException("班级不能为空!");
		//设置好双向关联
		if(students!=null){
			grade.setStudents(students);
			for(Student stu:students){
				stu.setGrade(grade);
			}
		}
		gradeRepository.save(grade);
	}
	
	/**
	 * 
	 * @param grades
	 * <p>Description:新增多多的班级<p/>
	 */
	public void addGrades(List<Grade> grades){
		gradeRepository.save(grades);
	}
	
	
	/**
	 * 
	 * @param gradeName
	 * @return
	 * <p>Description:根据班级的名字来查询有哪些学生，利用Query查询<p/>
	 */
	/*public List<Student> getGradeStus(String gradeName){
		return studentRepository.findByGName(gradeName);
	}*/
	
	/**
	 * 
	 * @param gradeName
	 * @return
	 * <p>Description:与上面的那个方法业务相同，只是换了一种方式<p/>
	 */
	@Transactional(/*propagation=Propagation.REQUIRES_NEW*/)
	public List<Student> getGradeStus(String gradeName){
		List<Student> students = gradeRepository.findByName(gradeName).getStudents();
		return students;
	}
	
	/**
	 * 
	 * @param gradeName
	 * <p>Description:为了测试缓存用<p/>
	 */
	public Grade getGradeByName(String gradeName){
		return gradeRepository.findByName(gradeName);
	}
	
	/*public void addGrade(Grade g){
		gradeRepository.save(g);
		logRepository.save(new Log("尝试存储"+g.getName()));
		throw new RuntimeException("测试事务一致性");
	}*/
}
