package com.college.voiceapp.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserDetails {
	@Id
	@GeneratedValue
	private int userId;
	public UserDetails() {
		super();
	}
	private String userName;
	public UserDetails(String userName, int userType) {
		super();
		this.userName = userName;
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userType=" + userType + "]";
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
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	private int userType;

}
