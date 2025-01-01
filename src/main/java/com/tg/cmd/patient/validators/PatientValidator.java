package com.tg.cmd.patient.validators;

import com.tg.cmd.patient.dto.patient.AddressDTO;
import com.tg.cmd.patient.dto.patient.FamilyMemberDTO;
import com.tg.cmd.patient.dto.patient.PatientDTO;
import com.tg.cmd.patient.exceptions.InvalidAddressException;
import com.tg.cmd.patient.exceptions.InvalidDateOfBirthException;
import com.tg.cmd.patient.exceptions.InvalidFamilyMemberException;
import com.tg.cmd.patient.exceptions.InvalidGenderException;
import com.tg.cmd.patient.exceptions.InvalidNameException;
import com.tg.cmd.patient.exceptions.InvalidPhoneNumberException;
import com.tg.cmd.patient.model.Patient;
import com.tg.cmd.patient.model.Patient.Gender;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

/**
 * Validator class for validating patient data.
 * This class checks the integrity of the patient's information before saving it to the database.
 */
@Component
public class PatientValidator implements IPatientValidator {

    /**
     * Validates the data provided in the PatientDTO.
     * Throws exceptions if any validation fails.
     * 
     * @param patientDTO the patient data transfer object
     * @return true if all data is valid
     * @throws InvalidNameException if the name is invalid
     * @throws InvalidPhoneNumberException if the phone number is invalid
     * @throws InvalidDateOfBirthException if the date of birth is invalid
     * @throws InvalidGenderException if the gender is invalid
     * @throws InvalidAddressException if the address is invalid
     * @throws InvalidFamilyMemberException if family members are invalid
     */
    @Override
    public boolean validatePatientData(PatientDTO patientDTO) 
            throws InvalidNameException, InvalidPhoneNumberException, InvalidDateOfBirthException, InvalidGenderException,
                   InvalidAddressException, InvalidFamilyMemberException {

        // Validate full name to contain only alphabetic characters and spaces
        if (patientDTO.getFullName() == null || patientDTO.getFullName().trim().isEmpty() || !isValidName(patientDTO.getFullName())) {
            throw new InvalidNameException("Full name must contain only alphabetic characters and spaces.");
        }

        // Validate phone number to ensure it is exactly 10 digits
        if (patientDTO.getPhoneNumber() == null || !isValidPhoneNumber(patientDTO.getPhoneNumber())) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }

        // Validate date of birth to ensure the patient's age is between 1 day and 150 years
        if (patientDTO.getDateOfBirth() == null || !isValidDateOfBirth(patientDTO.getDateOfBirth())) {
            throw new InvalidDateOfBirthException("Patient's age must be between 1 day and 150 years.");
        }

        // Validate gender to ensure it is a valid enum value
        if (patientDTO.getGender() == null) {
            throw new InvalidGenderException("Invalid gender value provided.");
        }

        return true; // All validations passed
    }

    // Helper method to validate phone numbers (must be exactly 10 digits)
    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.length() == 10 && phoneNumber.matches("[0-9]+");
    }

    // Helper method to validate names (only alphabetic characters and spaces allowed)
    public boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z\\s]+");
    }

    // Helper method to validate date of birth (age must be between 0 and 150)
    public boolean isValidDateOfBirth(LocalDate dob) {
        if (dob == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        return age >= 0 && age <= 150;
    }

    
}
