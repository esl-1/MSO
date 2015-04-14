package com.eslauer.persistence;

import java.util.List;

import com.eslauer.models.Schedule;

/**
 * DAO interface for patient table.
 * 
 * @author Edwin
 *
 */
public interface IScheduleDAO {
	
	/**
	 * 
	 * @return List of all Schedules
	 */
	List<Schedule> getAllSchedules();

	
	/**
	 * Adds the new Schedule.
	 * @param Schedule
	 */
	void add(Schedule Schedule);
	
	/**
	 * Updates the specified Schedule.
	 * @param Schedule
	 */
	void update(Schedule Schedule);
	
	/**
	 * Deletes the specified Schedule.
	 * @param Schedule
	 */
	void delete(Schedule Schedule);
}

