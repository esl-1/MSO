package com.eslauer.controllers;

import java.util.List;

import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eslauer.models.User;

@Component
@SessionScoped
public class UserRegistrationBean {
	
	private Logger logger = Logger.getLogger(UserRegistrationBean.class);
	
	private String username;
	private String password;
	private String passwordConfirm;
	private String nickname;
	private String email;
	private Boolean userExists = false;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DaoController daoController = new DaoController();
	
	public String register() {
		logger.info("Registering...");
		
		// get list of users from database
		List<User> userList = daoController.getUserDAOImpl().getAllUsers();
		String url = "/register.xhtml?faces-redirect=true";

		// Check if userName already exists
		for (User user : userList) {
			if (user.getUserName().equals(username)) {
				// UserName already taken: user must
				// choose another username
				userExists = true;
				username = "";
				password = "";
				passwordConfirm = "";

				logger.info("Registration failed! Username already taken.");
				return url;
			}
		}
		
		// don't render error-message in web page
		userExists = false;
		
		// create a new user
		User user = new User();
		user.setEmail(email);
		user.setUserName(username);
		// hash password for security
		String pwHashed = BCrypt.hashpw(password, BCrypt.gensalt());
		user.setPassword(pwHashed);
		user.setNickname(nickname);
		
		// add to user table
		daoController.getUserDAOImpl().add(user);
		
		logger.info("Registered");
		
		return "/index.xhtml?faces-redirect=true";
	}

	public Boolean getUserExists() {
		return userExists;
	}

	public void setUserExists(Boolean userExists) {
		this.userExists = userExists;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DaoController getDaoController() {
		return daoController;
	}

	public void setDaoController(DaoController daoController) {
		this.daoController = daoController;
	}

}
