package com.tg.cmd.patient.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(generator = "patient-id-generator")
    @GenericGenerator(name = "patient-id-generator", strategy = "com.tg.cmd.patient.model.IdGenerator")
    private String id;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private String preferredClinicID;
    private String preferredClinicName;
    private String emergencyContactName;
    private String conditionName;
    private LocalDate diagnosisDate;

    @Embedded
    private Address address;
    
    @Embedded
    
    private FamilyMember familyMember;
    
  

    public enum Gender {
        MALE, FEMALE, OTHERS
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Document> documents;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PatientInsurance> insurances;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PatientMedicalCondition> conditions;



    @Embedded
    private Doctor doctor;

    @Embedded
    private Clinic clinic;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
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
	public String getPreferredClinicID() {
		return preferredClinicID;
	}

	/**
	 * @param preferredClinicID the preferredClinicID to set
	 */
	public void setPreferredClinicID(String preferredClinicID) {
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

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}



	/**
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	/**
	 * @return the insurances
	 */
	public List<PatientInsurance> getInsurances() {
		return insurances;
	}

	/**
	 * @param insurances the insurances to set
	 */
	public void setInsurances(List<PatientInsurance> insurances) {
		this.insurances = insurances;
	}

	/**
	 * @return the conditions
	 */
	public List<PatientMedicalCondition> getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(List<PatientMedicalCondition> conditions) {
		this.conditions = conditions;
	}



	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the clinic
	 */
	public Clinic getClinic() {
		return clinic;
	}

	/**
	 * @param clinic the clinic to set
	 */
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	/**
	 * @return the familyMember
	 */
	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	/**
	 * @param familyMember the familyMember to set
	 */
	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
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
	
	
    
    
}
