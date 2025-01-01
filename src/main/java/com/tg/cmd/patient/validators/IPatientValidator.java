package com.tg.cmd.patient.validators;

import com.tg.cmd.patient.dto.patient.PatientDTO;
import com.tg.cmd.patient.exceptions.InvalidAddressException;
import com.tg.cmd.patient.exceptions.InvalidClinicNameException;
import com.tg.cmd.patient.exceptions.InvalidClinicSlotTimingsException;
import com.tg.cmd.patient.exceptions.InvalidDateOfBirthException;
import com.tg.cmd.patient.exceptions.InvalidDoctorNameException;
import com.tg.cmd.patient.exceptions.InvalidDoctorSlotTimingsException;
import com.tg.cmd.patient.exceptions.InvalidEmailException;
import com.tg.cmd.patient.exceptions.InvalidEmergencyContactException;
import com.tg.cmd.patient.exceptions.InvalidFamilyMemberException;
import com.tg.cmd.patient.exceptions.InvalidGenderException;
import com.tg.cmd.patient.exceptions.InvalidNameException;
import com.tg.cmd.patient.exceptions.InvalidPhoneNumberException;

/**
 * Interface for patient validation operations in the patient management system.
 * This interface defines the methods required to validate patient data, ensuring that
 * the information entered is accurate and meets the specified criteria.
 */
public interface IPatientValidator {

    /**
     * Validates patient data based on a set of criteria.
     * 
     * @param patient The patient data transfer object containing details of the patient.
     * @return True if the patient data is valid, otherwise false.
     * @throws InvalidAddressException If the address provided is invalid.
     * @throws InvalidNameException If the patient's name is invalid.
     * @throws InvalidPhoneNumberException If the phone number is invalid.
     * @throws InvalidEmergencyContactException If the emergency contact details are invalid.
     * @throws InvalidDateOfBirthException If the date of birth is invalid.
     * @throws InvalidGenderException If the gender provided is invalid.
     * @throws InvalidClinicNameException If the clinic name is invalid.
     * @throws InvalidClinicSlotTimingsException If the clinic's slot timings are invalid.
     * @throws InvalidDoctorNameException If the doctor's name is invalid.
     * @throws InvalidDoctorSlotTimingsException If the doctor's slot timings are invalid.
     * @throws InvalidFamilyMemberException 
     * @throws InvalidEmailException 
     */
    boolean validatePatientData(PatientDTO patient) 
        throws InvalidAddressException, InvalidNameException, InvalidPhoneNumberException, 
               InvalidEmergencyContactException, InvalidDateOfBirthException, InvalidGenderException, 
               InvalidDoctorNameException, InvalidDoctorSlotTimingsException, 
               InvalidClinicNameException, InvalidClinicSlotTimingsException, InvalidEmailException, InvalidFamilyMemberException, InvalidFamilyMemberException;

}
