package com.tg.cmd.patient.dto.patient;

import com.tg.cmd.patient.model.FamilyMember;
import jakarta.validation.constraints.NotNull;

public class FamilyMemberDTO {
    
    @NotNull
    private String familyMemberName;
    
    @NotNull
    private String familyMemberPhoneNumber;
    
    @NotNull(message = "Relationship type cannot be null")
    private FamilyMember.relationshipType relationshipType;

    // Getter and Setter for familyMemberName
    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    // Getter and Setter for familyMemberPhoneNumber
    public String getFamilyMemberPhoneNumber() {
        return familyMemberPhoneNumber;
    }

    public void setFamilyMemberPhoneNumber(String familyMemberPhoneNumber) {
        this.familyMemberPhoneNumber = familyMemberPhoneNumber;
    }

    // Getter and Setter for relationshipType
    public FamilyMember.relationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(FamilyMember.relationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }
}
