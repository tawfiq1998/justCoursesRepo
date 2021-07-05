package com.taw.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.taw.assets.*;

import bean.HomeBean;
import model.User;

public class SignerService extends Commons<Object> {
	public SignerService() {
		super(SignerService.class);
	}

	HomeBean bean = new HomeBean();

	/** this method to check loggin information */
	public void loginInfo(String userName, String password) {
		commonLoger.info("start loginInfo method");
		StringBuilder message = new StringBuilder();
		message.append(Checker.isEmpty(userName, "username "));// check if username is empty add username to the message
		message.append(Checker.isEmpty(password, "password "));// check if password is empty add password to the message

		if (message.length() != 0) { // if username or password is impty push worning
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message.toString() + "can't be empty"));
			return;
		}

		if (password.length() < 5) { // if password length less than 5 chars push worning
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("password should be longer than 5 digits"));
			return;
		}
		User user = bean.checkUser(userName, password);// check user info

		if (user == null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("wrong info"));
	}

	/** this method to creat new account */
	public void signUp(String userName, String password, String department) {
		commonLoger.info("start signUp method");
		StringBuilder message = new StringBuilder();
		message.append(Checker.isEmpty(userName, "username "));// check if username is empty add username to the message
		message.append(Checker.isEmpty(password, "password "));// check if password is empty add password to the message
		message.append(Checker.isEmpty(department, "department "));// check if password is empty add password to the
																	// message

		if (message.length() != 0) { // if username or password is impty push worning
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message.toString() + "can't be empty"));
			return;
		}

		if (password.length() < 5) { // if password length less than 5 chars push worning
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("password should be longer than 5 digits"));
			return;
		}
		User user = bean.signUp(new User(userName, password,department));
		// check user info

		if (user == null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("wrong info"));
	}
}
