package com.taw.backing;

import com.taw.service.SignerService;

public class SignerBacking {

	private SignerService signer = new SignerService(); // to use Homeservice

	private String userName; // to hold username when login
	private String password; // to hold password when login

	private String newUserName; // to hold username when sign up
	private String newPassword; // to hold password when sign up
	private String userDepartment; // to hold dept of new user when sign up

	/**
	 * use sing in method in Signer class
	 */
	public void loginInfo() {
		signer.loginInfo(userName, password);
	}

	/**
	 * use sing in method in Signer class
	 */
	public void singUp() {
		signer.signUp(newUserName, newPassword, userDepartment);
	}

	public SignerService getSigner() {
		return signer;
	}

	public void setSigner(SignerService signer) {
		this.signer = signer;
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

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
}
