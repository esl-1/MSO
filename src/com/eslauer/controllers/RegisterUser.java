package com.eslauer.controllers;

import java.util.List;

import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eslauer.models.User;
import com.eslauer.persistence.UserDaoImpl;

@Component
@SessionScoped
public class RegisterUser {
	
	private Logger logger = Logger.getLogger(RegisterUser.class);
	
	private String userName;
	private String password;
	private String passwordConfirm;
	private String nickName;
	private String email;
	private Boolean userExists = false;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DAOController daoController = new DAOController();
	
	public String register() {
		logger.info("Registering...");
		
		// get list of users from database
		List<User> userList = daoController.getUserDaoImpl().getAllUsers();
		String url = "/register.xhtml?faces-redirect=true";

		// Check if userName already exists
		for (User user : userList) {
			if (user.getUserName().equals(userName)) {
				// UserName already taken: user must
				// choose another username
				userExists = true;
				userName = "";
				password = "";
				passwordConfirm = "";

				logger.info("Registration failed! UserName already taken.");
				return url;
			}
		}
		
		// don't render error-message in web page
		userExists = false;
		
		// create a new user
		User user = new User();
		user.setEmail(email);
		user.setUserName(userName);
		// hash password for security
		String pwHashed = BCrypt.hashpw(password, BCrypt.gensalt());
		user.setPassword(pwHashed);
		user.setNickName(nickName);
		
		
		
		// add to user table
		daoController.getUserDaoImpl().add(user);
		
		logger.info("registered");
		
		return "/index.xhtml?faces-redirect=true";
	}

	//--- Getters and Setters ---
	
	public String getUserName() {
		return userName;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DAOController getDaoController() {
		return daoController;
	}

	public void setDaoController(DAOController daoController) {
		this.daoController = daoController;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getUserExists() {
		return userExists;
	}

	public void setUserExists(Boolean userExists) {
		this.userExists = userExists;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
}
