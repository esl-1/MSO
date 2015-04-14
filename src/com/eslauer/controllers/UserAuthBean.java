package com.eslauer.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eslauer.models.User;
import com.eslauer.persistence.IUserDAO;
import com.eslauer.persistence.UserDAOImpl;

@Component
@Scope("session")
public class UserAuthBean {
	
	private Logger logger = Logger.getLogger(UserAuthBean.class);
	
	private String username;
	private String password;
	private Boolean authenticated = false;
	private User user = new User();
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DaoManager daoManager = new DaoManager();

	public String login() {
		logger.info("Logging in....");
		authenticated = false;
		List<User> users = null;
		users = daoManager.getUserDao().getAllUsers();
		if(users == null){
			return "index.xhtml";
		}
		String url = "login.xhtml?faces-redirect=true";
		
		// check for user in database
		for (User usr : users) {
			if (usr.getUsername().equals(username)
					&& BCrypt.checkpw(password, usr.getPassword())) {
				authenticated = true;
				this.setUser(usr);
				
				// clear fields
				password = "";
				username = "";
				url = "/views/home.xhtml?faces-redirect=true";
				break;// exit for-loop
			}
		}
		logger.info("Logged in");
		return url;
	}
	
	public String logout(){
		authenticated = false;
		username = "";
		password = "";
		user = null;
		return "/login.xhtml?faces-redirect=true";
	}

	//------ Getters and Setters ------
	
	public DaoManager getDaoManager() {
		return daoManager;
	}

	public void setDaoManager(DaoManager daoManager) {
		this.daoManager = daoManager;
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

	public Boolean isAuthenticated() {
		return authenticated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
