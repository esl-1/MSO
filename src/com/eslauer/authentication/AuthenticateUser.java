package com.eslauer.authentication;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SessionScoped
public class AuthenticateUser {
	
	private String userName;
	private String password;
	private String nickName;
	
	@Autowired
	private Boolean authenticated = false;
	
	public String login(){
		
		
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
