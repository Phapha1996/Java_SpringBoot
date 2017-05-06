package org.fage.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_student")
public class Student{
	private String id;
	private String name;
	private int score;
	private Date birthday;
	private Grade grade;
	
	public Student(){
		super();
	}
	
	
	
	public Student(String name, int score, Date birthday) {
		super();
		this.name = name;
		this.score = score;
		this.birthday = birthday;
	}



	public Student(String name, int score, Date birthday, Grade grade) {
		super();
		this.name = name;
		this.score = score;
		this.birthday = birthday;
		this.grade = grade;
	}

	public Student(String id, String name, int score, Date birthday, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.birthday = birthday;
		this.grade = grade;
	}

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Grade.class)
	@JoinColumn(name="grade_id",nullable=false)
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
