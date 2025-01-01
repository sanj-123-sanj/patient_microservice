package com.tg.cmd.patient.patientService;

import java.util.List;

import com.tg.cmd.patient.dto.patient.AddressDTO;
import com.tg.cmd.patient.dto.patient.FamilyMemberDTO;
import com.tg.cmd.patient.dto.patient.PatientDTO;
import com.tg.cmd.patient.exceptions.AddressNotFoundException;
import com.tg.cmd.patient.exceptions.FamilyMemberNotFoundException;
import com.tg.cmd.patient.exceptions.InvalidAddressException;
import com.tg.cmd.patient.exceptions.InvalidDateOfBirthException;
import com.tg.cmd.patient.exceptions.InvalidFamilyMemberException;
import com.tg.cmd.patient.exceptions.InvalidGenderException;
import com.tg.cmd.patient.exceptions.InvalidNameException;
import com.tg.cmd.patient.exceptions.InvalidPhoneNumberException;
import com.tg.cmd.patient.exceptions.PatientAlreadyExistsException;
import com.tg.cmd.patient.exceptions.PatientNotFoundException;
import com.tg.cmd.patient.model.Address;
import com.tg.cmd.patient.model.FamilyMember;
import com.tg.cmd.patient.model.Patient;

/**
 * Interface defining operations for managing patient information.
 */
public interface PatientService {

    /**
     * Registers a new patient.
     *
     * @param patientDTO the data transfer object containing patient details
     * @return the registered PatientDTO object
     * @throws PatientAlreadyExistsException if a patient with the same details already exists
     * @throws InvalidNameException if the name is invalid
     * @throws InvalidPhoneNumberException if the phone number is invalid
     * @throws InvalidDateOfBirthException if the date of birth is invalid
     * @throws InvalidGenderException if the gender is invalid
     * @throws InvalidFamilyMemberException 
     * @throws InvalidAddressException 
     */
    PatientDTO addPatient(PatientDTO patientDTO) 
            throws PatientAlreadyExistsException, InvalidNameException, InvalidPhoneNumberException, 
                   InvalidDateOfBirthException, InvalidGenderException, InvalidAddressException, InvalidFamilyMemberException;

    /**
     * Retrieves a patient's details by their ID.
     *
     * @param patientId the ID of the patient
     * @return the PatientDTO object
     * @throws PatientNotFoundException if the patient is not found
     */
    PatientDTO getPatientDetailsById(String patientId) throws PatientNotFoundException;

    /**
     * Retrieves a list of all patients.
     *
     * @return a list of PatientDTO objects
     */
    List<PatientDTO> getAllPatients();

    /**
     * Updates a patient's phone number.
     *
     * @param patientId the ID of the patient
     * @param phone the new phone number
     * @return the updated Patient entity
     * @throws PatientNotFoundException if the patient is not found
     * @throws InvalidPhoneNumberException if the phone number is invalid
     */
    Patient updatePatientPhone(String patientId, String phone) 
            throws PatientNotFoundException, InvalidPhoneNumberException;

    /**
     * Deletes a patient by their ID.
     *
     * @param patientId the ID of the patient to delete
     * @return true if successfully deleted, false otherwise
     */
    boolean deletePatient(String patientId);

    /**
     * Retrieves the addresses associated with a specific patient.
     *
     * @param patientId the ID of the patient
     * @return a list of AddressDTO objects
     * @throws AddressNotFoundException if no addresses are found
     */
    List<AddressDTO> getPatientAddresses(String patientId) throws AddressNotFoundException;

    /**
     * Retrieves the family members associated with a specific patient.
     *
     * @param patientId the ID of the patient
     * @return a list of FamilyMemberDTO objects
     * @throws FamilyMemberNotFoundException if no family members are found
     */
    List<FamilyMemberDTO> getPatientFamilyMembers(String patientId) throws FamilyMemberNotFoundException;

}
