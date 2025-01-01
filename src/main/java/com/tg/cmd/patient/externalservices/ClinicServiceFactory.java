package com.tg.cmd.patient.externalservices;
/**
 * Factory class to create instances of IClinicService based on the choice (real or mock).
 * This allows for flexible switching between a real implementation (remote) or a mock implementation 
 * for testing purposes.
 */

public class ClinicServiceFactory {
	/**
     * Creates an instance of IClinicService based on the provided choice.
     *
     * @param choice The choice to select the type of IClinicService to create ("remote" or "mock").
     * @return An instance of IClinicService (either a real or mock implementation).
     * @throws IllegalArgumentException If the provided choice is invalid.
     */

	public static IClinicService create(String choice) {
		// Return the real implementation (remote) if the choice is "remote"
		if ("remote".equals(choice))
			return new ClinicServiceImpl();
		// Return the mock implementation if the choice is "mock"
		else if ("mock".equals(choice))
			return new ClinicServiceMockImpl();
		 // Throw an exception if the choice is neither "remote" nor "mock"
		else
			throw new IllegalArgumentException("Invalid choice: " + choice);

	}

}

