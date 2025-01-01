package com.tg.cmd.patient.dto.patient;

import java.time.LocalDate;
import java.util.List;

import com.tg.cmd.patient.model.FamilyMember;
import com.tg.cmd.patient.model.Patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PatientDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String gender;
    private String phoneNumber;
    private Integer preferredClinicID;
    private String preferredClinicName;
    private String emergencyContactName;
    private AddressDTO addressDTO;
    private FamilyMemberDTO familyMemberDTO;
    private String conditionName;
    private LocalDate diagnosisDate;
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the preferredClinicID
	 */
	public Integer getPreferredClinicID() {
		return preferredClinicID;
	}
	/**
	 * @param preferredClinicID the preferredClinicID to set
	 */
	public void setPreferredClinicID(Integer preferredClinicID) {
		this.preferredClinicID = preferredClinicID;
	}
	/**
	 * @return the preferredClinicName
	 */
	public String getPreferredClinicName() {
		return preferredClinicName;
	}
	/**
	 * @param preferredClinicName the preferredClinicName to set
	 */
	public void setPreferredClinicName(String preferredClinicName) {
		this.preferredClinicName = preferredClinicName;
	}
	/**
	 * @return the emergencyContactName
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	/**
	 * @param emergencyContactName the emergencyContactName to set
	 */
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	/**
	 * @return the addressDTO
	 */
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	/**
	 * @param addressDTO the addressDTO to set
	 */
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	/**
	 * @return the familyMemberDTO
	 */
	public FamilyMemberDTO getFamilyMemberDTO() {
		return familyMemberDTO;
	}
	/**
	 * @param familyMemberDTO the familyMemberDTO to set
	 */
	public void setFamilyMemberDTO(FamilyMemberDTO familyMemberDTO) {
		this.familyMemberDTO = familyMemberDTO;
	}
	/**
	 * @return the conditionName
	 */
	public String getConditionName() {
		return conditionName;
	}
	/**
	 * @param conditionName the conditionName to set
	 */
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	/**
	 * @return the diagnosisDate
	 */
	public LocalDate getDiagnosisDate() {
		return diagnosisDate;
	}
	/**
	 * @param diagnosisDate the diagnosisDate to set
	 */
	public void setDiagnosisDate(LocalDate diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

   
}
