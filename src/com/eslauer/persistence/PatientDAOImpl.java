package com.eslauer.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eslauer.models.Patient;

@Component
@Scope("session")
@Transactional
public class PatientDAOImpl implements IPatientDAO {

	private Logger logger = Logger.getLogger(PatientDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getAllPatients() {
		logger.info("Getting list of all PATIENTS.");
		
		List<Patient> list = null;
		list = sessionFactory.getCurrentSession().createQuery("From Patient Order By lastName").list();
		return list;
	}

	@Override
	public Patient getPatientBySSN(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Patient Patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Patient Patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Patient Patient) {
		// TODO Auto-generated method stub

	}

}
