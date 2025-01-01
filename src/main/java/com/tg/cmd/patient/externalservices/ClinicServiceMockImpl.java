 package com.tg.cmd.patient.externalservices;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.tg.cmd.patient.model.Clinic;

/**
 * Mock implementation of the IClinicService interface.
 * This is used for testing purposes and simulates the behavior of a real clinic service.
 */
@Service
public class ClinicServiceMockImpl implements IClinicService {

    /**
     * Checks if an appointment is available at a given clinic during the preferred time slot.
     *
     * @param primaryClinicId      The ID of the clinic.
     * @param preferredStartTime   The preferred start time for the appointment.
     * @param preferredEndTime     The preferred end time for the appointment.
     * @return true if the appointment is available during the preferred time, false otherwise.
     */
    public boolean isAppointmentAvailable(String primaryClinicId, LocalTime preferredStartTime, LocalTime preferredEndTime) {
        // Validate input parameters
        if (preferredStartTime == null || preferredEndTime == null) {
            throw new IllegalArgumentException("Preferred start time and end time cannot be null.");
        }
        if (!preferredStartTime.isBefore(preferredEndTime)) {
            throw new IllegalArgumentException("Preferred start time must be before the end time.");
        }

        // Creating mock clinic details
        Clinic clinic = new Clinic();
        clinic.setId("CLI123");
        clinic.setClinicName("Olia Clinic");

        // Setting clinic working hours (mock values)
        LocalTime clinicStartTime = LocalTime.of(8, 0);  // Clinic opening time
        LocalTime clinicEndTime = LocalTime.of(18, 0); // Clinic closing time
        clinic.setStartTime(clinicStartTime);
        clinic.setEndTime(clinicEndTime);

        // Check if the preferred time slot is strictly within the clinic's working hours
        if (preferredStartTime.isAfter(clinicStartTime) && preferredEndTime.isBefore(clinicEndTime)) {
            return true; // Appointment available
        }

        return false; // Appointment not available
    }
}
