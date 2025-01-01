package com.tg.cmd.patient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class PatientInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID for the insurance record
    private Long id;

    // Many-to-One relationship with the Patient entity, establishing a foreign key reference to Patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Foreign key to Patient
    private Patient patient;

    private String provider;  // Name of the insurance provider (e.g., "BlueCross", "Aetna")
    private String policyNumber;  // Unique policy number for the insurance
    private String coverageDetails;  // Details of the insurance coverage (e.g., "Full dental coverage")

    private LocalDate expirationDate;  // Expiration date of the insurance policy

    // Enum for different types of insurance coverage (Health, Dental, Vision, etc.)
    @Enumerated(EnumType.STRING)  // Stores enum values as strings in the database (e.g., "HEALTH", "DENTAL")
    private InsuranceType insuranceType;  // Type of insurance (Health, Dental, Vision, etc.)

    // Enum definition for different types of insurance
    public enum InsuranceType {
        HEALTH,   // Health insurance
        DENTAL,   // Dental insurance
        VISION,   // Vision insurance
        LIFE,     // Life insurance
        OTHER     // Any other type of insurance not listed
    }
}
