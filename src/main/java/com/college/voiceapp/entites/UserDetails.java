package com.college.voiceapp.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserDetails implements Serializable {
	@Id
	@GeneratedValue
	private int userId;	
	private String userName;
	private String password;
	private int userType;
	private Date createdDate;
	
	public UserDetails() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserDetails(String userName, String password, int userType, Date createdDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + ", createdDate=" + createdDate + "]";
	}
	
	
	
	
}
