package com.eslauer.controllers;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eslauer.persistence.IPatientDAO;
import com.eslauer.persistence.IScheduleDAO;
import com.eslauer.persistence.IUserDAO;
import com.eslauer.persistence.PatientDAOImpl;
import com.eslauer.persistence.ScheduleDAOImpl;
import com.eslauer.persistence.UserDAOImpl;

@Component
@Scope("session")
@Transactional
public class DaoManager {
	
	private Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// dao implementors
	@Autowired
	private IUserDAO userDao = new UserDAOImpl();
	
	@Autowired
	private IPatientDAO patientDao = new PatientDAOImpl();
	
	@Autowired
	private IScheduleDAO scheduleDao = new ScheduleDAOImpl();
	
	
	//  getters setters

	public IScheduleDAO getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(IScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public IPatientDAO getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IPatientDAO patientDao) {
		this.patientDao = patientDao;
	}

}
