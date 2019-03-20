package org.niraj.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CompanyUserVO {

	private int userId;
	
	@NotNull
	@NotEmpty
	@Size(min=5 , max=20)
	private String userName;

	@NotNull
	@NotEmpty
	@Size(min=5 , max=20)
	private String password;
	
	private String fullname;
	private String email;
	private String mobile;
	private String userRole;
	private String userStatus;

	
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "CompanyUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullname="
				+ fullname + ", email=" + email + ", mobile=" + mobile + ", userRole=" + userRole + ", userStatus="
				+ userStatus + "]";
	}
	
	
	
	
}
