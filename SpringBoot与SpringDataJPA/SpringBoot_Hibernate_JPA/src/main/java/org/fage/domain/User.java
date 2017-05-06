package org.fage.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author Fapha
 * @date 2017年4月11日下午2:18:09
 * @version v.0.1
 * <p>Description: 测试一对多，部门与用户之间</p>
 *
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{
	private int id;
	private String username;
	private String password;
	private Date birthday;
	private Department department;
	public User(){
		super();
	}
	
	
	public User(String username, String password, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@ManyToOne(optional=false,fetch=FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
