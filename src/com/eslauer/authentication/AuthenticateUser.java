package com.eslauer.authentication;

import javax.faces.bean.SessionScoped;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eslauer.models.User;
import com.eslauer.persistence.UserDaoImpl;

@Component
@SessionScoped
public class AuthenticateUser {
	
	private String userName;
	private String password;
	private String nickName;
	private User user = new User();
	private Boolean authenticated = false;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	public String login(){
		
		user.setNickName(nickName);
		user.setUserName(userName);
		user.setPassword(password);
	
		authenticated = true;
		return "/secured/welcome.xhtml";
	}

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Boolean isAuthenticated() {
		return authenticated;
	}

}
