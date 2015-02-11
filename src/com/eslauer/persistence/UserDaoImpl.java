package com.eslauer.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eslauer.models.User;

@Component
@Scope("session")
@Transactional
public class UserDaoImpl implements IUserDao {
	
	private Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUsers() {
		logger.info("Getting list of all users...");
		@SuppressWarnings("unchecked")
		List<User> list = sessionFactory.getCurrentSession().createQuery("From User").list();
		logger.info("Completed getting list of alll users.");
		return list;
	}

	@Override
	public User getUserByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> list = sessionFactory.getCurrentSession()
				.createQuery("From User where userName='"+username+"'").list();
		return list.get(0);
	}

	@Override
	public void add(User user) {
		logger.info("Adding a new user...");
		sessionFactory.getCurrentSession().save(user);
		logger.info("Completed adding a new User.");
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

}
