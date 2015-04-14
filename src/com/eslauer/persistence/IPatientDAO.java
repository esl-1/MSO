package com.eslauer.persistence;

import java.util.List;

import com.eslauer.models.Patient;

/**
 * DAO interface for patient table.
 * 
 * @author Edwin
 *
 */
public interface IPatientDAO {
	
	/**
	 * 
	 * @return List of all PatientS
	 */
	List<Patient> getAllPatients();
	
	/**
	 * 
	 * @param Patientname
	 * @return Patient
	 */
	Patient getPatientBySSN(String ssn);
	
	/**
	 * Adds the new Patient.
	 * @param Patient
	 */
	void add(Patient Patient);
	
	/**
	 * Updates the specified Patient.
	 * @param Patient
	 */
	void update(Patient Patient);
	
	/**
	 * Deletes the specified Patient.
	 * @param Patient
	 */
	void delete(Patient Patient);
}
