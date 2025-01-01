package com.tg.cmd.patient.externalservices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tg.cmd.patient.model.Doctor;

import java.time.LocalTime;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${doctorServiceUrl}")
    private String doctorServiceUrl;

    /**
     * Checks if the doctor is available during the preferred time by calling an external API.
     * Includes Resilience4j Circuit Breaker for fault tolerance.
     *
     * @param doctorId       ID of the doctor.
     * @param preferredStart Preferred start time for the appointment.
     * @param preferredEnd   Preferred end time for the appointment.
     * @return true if the doctor is available, false otherwise.
     */
    @CircuitBreaker(name = "doctorService", fallbackMethod = "fallbackDoctorAvailability")
    public boolean isDoctorAvailable(String doctorId, LocalTime preferredStart, LocalTime preferredEnd) {
        // Construct the URL for the API call to check doctor availability
        String url = doctorServiceUrl + "/api/doctors/" + doctorId + "/availability" +
                     "?preferredStartTime=" + preferredStart + 
                     "&preferredEndTime=" + preferredEnd;

        // Make a GET request to the external service and get the response
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);

        // Return the response body if it's not null, otherwise return false
        return response.getBody() != null && response.getBody();
    }

    /**
     * Fallback method for doctor availability check.
     * 
     * @param doctorId       ID of the doctor.
     * @param preferredStart Preferred start time for the appointment.
     * @param preferredEnd   Preferred end time for the appointment.
     * @param throwable      The exception that caused the fallback to be triggered.
     * @return false as the fallback behavior.
     */
    public boolean fallbackDoctorAvailability(String doctorId, LocalTime preferredStart, LocalTime preferredEnd, Throwable throwable) {
        System.err.println("Fallback triggered for doctor availability. Reason: " + throwable.getMessage());
        return false; // Default behavior during fallback
    }

    /**
     * Retrieves the details of a doctor by their ID.
     * 
     * @param id ID of the doctor.
     * @return A mock Doctor object with the specified ID.
     */
    public Doctor getDoctorById(String id) {
        // Mocking a Doctor object for demonstration purposes
        Doctor doctor = new Doctor();
        doctor.setId(id);           // Set the doctor's ID
        doctor.setName("Dr. Example"); // Set a mock name
        doctor.setAvailable(true);  // Set the availability to true
        return doctor;
    }

    /**
     * Updates the details of a doctor by their ID.
     * 
     * @param id     ID of the doctor to update.
     * @param doctor A Doctor object containing the updated details.
     * @return The updated Doctor object.
     */
    public Doctor updateDoctor(String id, Doctor doctor) {
        // Fetch the existing doctor (mocked for this example)
        Doctor existingDoctor = getDoctorById(id);

        // Update the doctor's details
        existingDoctor.setName(doctor.getName());
        existingDoctor.setAvailable(doctor.isAvailable());

        // Return the updated doctor
        return existingDoctor;
    }

    /**
     * Checks if a doctor is available based on their availability status.
     *
     * @param id          ID of the doctor.
     * @param name        Name of the doctor.
     * @param isAvailable Availability status of the doctor.
     * @return true if the doctor is available, false otherwise.
     */
    @Override
    public boolean isDoctorAvailable(String id, String name, boolean isAvailable) {
        if (isAvailable) {
            // Fetch additional information about the doctor (e.g., working hours)
            Doctor doctor = getDoctorById(id);
            System.out.println("Doctor " + doctor.getName() + " is available.");
            return true;
        }
        System.out.println("Doctor with ID: " + id + " is not available.");
        return false;
    }

    /**
     * Checks if a doctor is available based on their availability status and preferred time.
     *
     * @param id                 ID of the doctor.
     * @param name               Name of the doctor.
     * @param isAvailable        Availability status of the doctor.
     * @param preferredStartTime Preferred start time for the appointment.
     * @param preferredEndTime   Preferred end time for the appointment.
     * @return true if the doctor is available during the preferred time, false otherwise.
     */
    public boolean isDoctorAvailable(String id, String name, boolean isAvailable, LocalTime preferredStartTime,
                                     LocalTime preferredEndTime) {
        // Check if the doctor is marked as available
        if (isAvailable) {
            // Define the doctor's working hours (9 AM to 5 PM in this example)
            LocalTime doctorStartTime = LocalTime.of(9, 0);
            LocalTime doctorEndTime = LocalTime.of(17, 0);

            // Verify if the preferred time falls within the doctor's working hours
            return !preferredStartTime.isBefore(doctorStartTime) &&
                   !preferredEndTime.isAfter(doctorEndTime) &&
                   !preferredStartTime.isAfter(preferredEndTime);
        }
        return false; // Return false if the doctor is not available
    }
}
