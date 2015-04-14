package com.eslauer.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eslauer.models.Schedule;

@Component
@Scope("session")
@Transactional
public class ScheduleDAOImpl implements IScheduleDAO {
	
	private Logger logger = Logger.getLogger(ScheduleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Schedule> getAllSchedules() throws ClassCastException {
		logger.info("Getting list of: ALL SCHEDULES");
		return sessionFactory.getCurrentSession().createQuery("From Schedule").list();
	}

	@Override
	public void add(Schedule Schedule) {
		logger.info("Adding object to: SCHEDULES");
		sessionFactory.getCurrentSession().save(Schedule);
	}

	@Override
	public void update(Schedule Schedule) {
		logger.info("Updating object to: SCHEDULES");
		sessionFactory.getCurrentSession().update(Schedule);	
	}

	@Override
	public void delete(Schedule Schedule) {
		logger.info("Removing object from: SCHEDULES");
		sessionFactory.getCurrentSession().delete(Schedule);	
	}

}
