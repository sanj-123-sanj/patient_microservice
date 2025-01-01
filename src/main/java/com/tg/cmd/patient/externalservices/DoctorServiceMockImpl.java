package com.tg.cmd.patient.externalservices;

import org.springframework.stereotype.Service;

import com.tg.cmd.patient.model.Doctor;

/**
 * Mock implementation of the IDoctorService interface.
 * This service is used for testing and simulating the behavior of the Doctor service.
 */
@Service
public class DoctorServiceMockImpl implements IDoctorService {

    /**
     * Checks if a doctor is available based on the provided ID, name, and availability status.
     * 
     * @param id          The unique identifier of the doctor.
     * @param name        The name of the doctor.
     * @param isAvailable Indicates if the doctor is currently available.
     * @return true if the doctor is available; false otherwise.
     */
    @Override
    public boolean isDoctorAvailable(String id, String name, boolean isAvailable) {
        // Create a mock Doctor object with the provided parameters
        Doctor doctor = new Doctor();
        doctor.setId(id);           // Set the doctor ID
        doctor.setName(name);       // Set the doctor's name
        doctor.setAvailable(isAvailable); // Set the doctor's availability

        // Return the availability status of the doctor
        return doctor.isAvailable();
    }

    /**
     * Retrieves the details of a doctor by their unique ID.
     * 
     * @param id The unique identifier of the doctor to fetch.
     * @return A Doctor object containing the details of the doctor.
     */
    @Override
    public Doctor getDoctorById(String id) {
        // Simulate fetching the doctor from a database or external service
        // Here, we return a mock Doctor object for testing purposes
        Doctor doctor = new Doctor();
        doctor.setId("DOC123");          // Set a mock ID for the doctor
        doctor.setName("Dr. Miaco"); // Set a mock name for the doctor
        doctor.setAvailable(true);  // Set the doctor as available

        // Return the mock doctor details
        return doctor;
    }
}
