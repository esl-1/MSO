package com.eslauer.persistence;

import java.util.Collections;
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
public class UserDAOImpl implements IUserDAO {
	
	private Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		logger.info("Getting list of all USERS.");
		
		List<User> list = null;
		list = sessionFactory.getCurrentSession().createQuery("From User").list();
		if(list == null){
			return Collections.emptyList();
		}
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
		logger.info("Adding a new USER.");
		sessionFactory.getCurrentSession().save(user);
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
