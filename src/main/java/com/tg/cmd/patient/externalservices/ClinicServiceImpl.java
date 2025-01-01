package com.tg.cmd.patient.externalservices;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tg.cmd.patient.PatientApplication;

/**
 * Implementation of the IClinicService interface that interacts with an external clinic service.
 * It checks if an appointment is available at a given clinic during a specified time slot.
 */
@Service
public class ClinicServiceImpl implements IClinicService {
	
	 Logger log = LoggerFactory.getLogger(PatientApplication.class);

    // Autowired RestTemplate to make HTTP requests to external services
    @Autowired
    private RestTemplate restTemplate;

    // The URL of the external clinic service, injected from the application properties
    @Value("${otherClinicServiceUrl}")
    private String otherClinicServiceUrl;

    /**
     * Checks if an appointment is available at the specified clinic during the preferred time slot.
     *
     * @param clinicId            The ID of the clinic.
     * @param preferredStartTime  The preferred start time for the appointment.
     * @param preferredEndTime    The preferred end time for the appointment.
     * @return true if the appointment is available, false otherwise.
     */
    @Override
    public boolean isAppointmentAvailable(String clinicId, LocalTime preferredStartTime, LocalTime preferredEndTime) {
        // Construct the URL for the external clinic service's API
        String url = otherClinicServiceUrl + "/api/clinics/" + clinicId + "/appointments/availability"
                + "?preferredStartTime=" + preferredStartTime + "&preferredEndTime=" + preferredEndTime;

        // Send the HTTP GET request to the external service and get the response
        try {
            ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
            return response.getBody() != null ? response.getBody() : false;
        } catch (Exception e) {
            // Handle exception if the external service is unavailable or the request fails
            log.error("Failed to check appointment availability for clinic ID: {}", clinicId, e);
            return false;
        }
    }

}
