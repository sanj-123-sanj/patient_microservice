package com.tg.cmd.patient.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Document {

    // Unique identifier for the Document entity (auto-generated)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-one relationship with the Patient entity (each document is associated with a patient)
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Foreign key to Patient, patient_id column in the document table
    private Patient patient;

    // Name of the document (e.g., "Prescription", "Lab Report")
    private String documentName;

    // Enum representing the type of document, stored as a string in the database
    @Enumerated(EnumType.STRING) // Ensures that enum values are stored as strings (e.g., "PRESCRIPTION")
    private DocumentType documentType; // Type of document (prescription, lab report, etc.)

    // Date and time when the document was uploaded
    private LocalDateTime uploadDate;

    // Enum to define possible document types
    public enum DocumentType {
        PRESCRIPTION,   // Prescription document type
        LAB_REPORT,    // Lab report document type
        XRAY,          // X-ray document type
        OTHER          // Other document type (for documents that don't fit into the predefined types)
    }
}
