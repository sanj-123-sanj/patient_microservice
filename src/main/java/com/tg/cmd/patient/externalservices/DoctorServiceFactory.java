package com.tg.cmd.patient.externalservices;

/**
 * Factory class to create instances of IDoctorService based on the choice (real or mock).
 * This provides a simple way to switch between real and mock implementations of the service.
 */
public class DoctorServiceFactory {

    /**
     * Creates an instance of IDoctorService based on the specified choice.
     *
     * @param choice The type of service to create ("real" or "mock").
     * @return An instance of IDoctorService (either real or mock implementation).
     * @throws IllegalArgumentException if the choice is invalid.
     */
    public static IDoctorService create(String choice) {
        // Check if the choice is "real" (case-insensitive) and return the real service implementation
        if ("real".equalsIgnoreCase(choice))
            return new DoctorServiceImpl();

        // Check if the choice is "mock" (case-insensitive) and return the mock service implementation
        else if ("mock".equalsIgnoreCase(choice))
            return new DoctorServiceMockImpl();

        // Throw an exception for any invalid choice
        else
            throw new IllegalArgumentException("Invalid choice: " + choice);
    }
}
