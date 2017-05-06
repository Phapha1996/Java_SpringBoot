package org.fage.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private int id;
	private String name;
	private Date birthday;
	
	public User(){
		super();
	}
	
	public User(int id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	//页面中不显示当前内容
	@JSONField(serialize=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//Json格式化日期类型
	@JSONField(format="yyyy-mm-dd hh:mm")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
