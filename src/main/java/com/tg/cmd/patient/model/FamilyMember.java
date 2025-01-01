package com.tg.cmd.patient.model;

import java.util.stream.Stream;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class FamilyMember {

    // Name of the family member
    private String familyMemberName;

    // Phone number of the family member
    private String familyMemberPhoneNumber;

    // Address of the family member
    private String address;

    // Enum representing the relationship type (e.g., SPOUSE, PARENT, CHILD, etc.)
    @Enumerated(EnumType.STRING) // Stores enum values as strings in the database
    private relationshipType relationshipType;

    // Enum to define possible relationship types between the family member and the patient
    public enum relationshipType {
        SPOUSE,  // Spouse of the patient
        PARENT,  // Parent of the patient
        CHILD,   // Child of the patient
        SIBLING, // Sibling of the patient
        OTHER    // Other types of relationship
    }


	/**
	 * @return the familyMemberName
	 */
	public String getFamilyMemberName() {
		return familyMemberName;
	}

	/**
	 * @param familyMemberName the familyMemberName to set
	 */
	public void setFamilyMemberName(String familyMemberName) {
		this.familyMemberName = familyMemberName;
	}

	/**
	 * @return the familyMemberPhoneNumber
	 */
	public String getFamilyMemberPhoneNumber() {
		return familyMemberPhoneNumber;
	}

	/**
	 * @param familyMemberPhoneNumber the familyMemberPhoneNumber to set
	 */
	public void setFamilyMemberPhoneNumber(String familyMemberPhoneNumber) {
		this.familyMemberPhoneNumber = familyMemberPhoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the relationshipType
	 */
	public relationshipType getRelationshipType() {
		return relationshipType;
	}

	/**
	 * @param relationshipType the relationshipType to set
	 */
	public void setRelationshipType(relationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}

	
}
