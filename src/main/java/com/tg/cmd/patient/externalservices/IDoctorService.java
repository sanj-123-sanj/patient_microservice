package com.tg.cmd.patient.externalservices;

import java.time.LocalTime;

import com.tg.cmd.patient.model.Doctor;

public interface IDoctorService {
    Doctor getDoctorById(String id);

    /**
     * Check if the doctor is available during the preferred time.
     *
     * @param doctorId         The doctor's ID.
     * @param preferredStart   The preferred start time.
     * @param preferredEnd     The preferred end time.
     * @return true if the doctor is available during the preferred time, otherwise false.
     */


	boolean isDoctorAvailable(String id, String name, boolean isAvailable);

	/**
	 * Checks if a doctor is available based on their availability status and preferred time.
	 *
	 * @param id                  ID of the doctor.
	 * @param name                Name of the doctor.
	 * @param isAvailable         Availability status of the doctor.
	 * @param preferredStartTime  Preferred start time for the appointment.
	 * @param preferredEndTime    Preferred end time for the appointment.
	 * @return true if the doctor is available during the preferred time, otherwise false.
	 */

}
