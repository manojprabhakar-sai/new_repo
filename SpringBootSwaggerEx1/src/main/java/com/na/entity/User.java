package com.na.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TAB")
public class User {
	@Id
	private Integer  userId;
	@Column(length=15)
	private  String  userName;
	@Column(length=40)
	private  String  email;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public  String  toString() {
		return  "User [userId"+userId+", userName="+userName+", email="+email+"]";
	}

}
