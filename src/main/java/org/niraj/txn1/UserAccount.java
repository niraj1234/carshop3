package org.niraj.txn1;

public class UserAccount {

	private int userPkId;
	private String userName;
	private String mobile;
	private String email;
	
	private int accountPkId;
	private int amount;
	private String accountStatus;
	private int fkUserId;
	
	
	public int getUserPkId() {
		return userPkId;
	}
	public void setUserPkId(int userPkId) {
		this.userPkId = userPkId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAccountPkId() {
		return accountPkId;
	}
	public void setAccountPkId(int accountPkId) {
		this.accountPkId = accountPkId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public int getFkUserId() {
		return fkUserId;
	}
	public void setFkUserId(int fkUserId) {
		this.fkUserId = fkUserId;
	}
	
}
