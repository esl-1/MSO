package com.eslauer.controllers;

import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eslauer.persistence.UserDaoImpl;

@Component
@SessionScoped
@Transactional
public final class DaoController {
	
	private Logger logger = Logger.getLogger(DaoController.class);

	@Autowired
	private SessionFactory sessionFactory;

	//----- DAO Implementors -----
	@Autowired
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	
	
	//----- GETTERS/SETTERS -----
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
}
