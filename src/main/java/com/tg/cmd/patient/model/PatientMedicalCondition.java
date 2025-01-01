package com.tg.cmd.patient.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class PatientMedicalCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID for each medical condition record
    private Long id;

    // Many-to-One relationship with the Patient entity, establishing a foreign key reference to Patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Foreign key to Patient, ensures each condition is linked to a specific patient
    private Patient patient;

    private String conditionName;  // Name of the medical condition (e.g., "Diabetes", "Hypertension")
    private String description;    // Description of the medical condition (e.g., "Chronic condition", "Acute illness")
    private LocalDate diagnosisDate;  // Date when the condition was diagnosed

    // Enum for the type of procedure associated with the medical condition (e.g., Surgery, Medication)
    @Enumerated(EnumType.STRING)  // Stores enum values as strings in the database (e.g., "SURGERY", "CHEMOTHERAPY")
    private ProcedureType procedureType;  // Type of medical procedure used to treat or manage the condition

    // Enum definition for ProcedureType
    public enum ProcedureType {
        SURGERY,        // Surgery for the medical condition
        PHYSIOTHERAPY,  // Physiotherapy as part of treatment
        CHEMOTHERAPY,   // Chemotherapy for cancer treatment
        RADIOTHERAPY,   // Radiotherapy for cancer treatment
        MEDICATION,     // Medication prescribed for the condition
        OTHER           // Any other procedure not listed
    }
}
