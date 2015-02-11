package com.eslauer.authentication;

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
public class AuthenticateUser {
	
	private Logger logger = Logger.getLogger(AuthenticateUser.class);
	
	private String userName;
	private String password;
	private Boolean authenticated = false;
	private User user = new User();
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	public String login() {
		logger.info("Logging in....");
		authenticated = false;
		List<User> users = userDaoImpl.getAllUsers();
		String url = "index.xhtml?faces-redirect=true";
		
		// check for user in database
		for (User aUser : users) {
			if (aUser.getUserName().equals(userName)
					&& BCrypt.checkpw(password, aUser.getPassword())) {
				authenticated = true;
				this.setUser(aUser);
				
				// clear password field
				password = "";
				url = "/secured/welcome.xhtml?faces-redirect=true";
			}
		}
		logger.info("logged in");
		return url;
	}
	
	public String logout(){
		authenticated = false;
		userName = "";
		password = "";
		user = null;
		return "/index.xhtml?faces-redirect=true";
	}

	//--- Getters and Setters ---
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@SuppressWarnings("unused")
	private String getPassword(){
		return password;
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
