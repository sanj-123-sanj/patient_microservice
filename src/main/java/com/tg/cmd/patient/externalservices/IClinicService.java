package com.tg.cmd.patient.externalservices;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

/**
 * Define the IClinicService interface we'll create two implementations of this
 * interface: one for real communication with the Other Clinic service
 * (ClinicServiceImpl) and one for providing mock data(ClinicServiceMockImpl)
 */
public interface IClinicService {

	/**
	 * Checks if an appointment is available at the specified clinic during the preferred time slot.
	 *
	 * @param clinicId            The ID of the clinic.
	 * @param preferredStartTime  The preferred start time for the appointment.
	 * @param preferredEndTime    The preferred end time for the appointment.
	 * @return true if the appointment is available, false otherwise.
	 */
	boolean isAppointmentAvailable(String clinicId, LocalTime preferredStartTime, LocalTime preferredEndTime);

	

}

