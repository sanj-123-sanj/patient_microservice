package com.tg.cmd.patient.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tg.cmd.patient.PatientApplication;
import com.tg.cmd.patient.dto.patient.AddressDTO;
import com.tg.cmd.patient.dto.patient.FamilyMemberDTO;
import com.tg.cmd.patient.dto.patient.PatientDTO;
import com.tg.cmd.patient.dto.patient.ResponseWrapper;
import com.tg.cmd.patient.exceptions.AddressNotFoundException;
import com.tg.cmd.patient.exceptions.FamilyMemberNotFoundException;
import com.tg.cmd.patient.exceptions.PatientNotFoundException;
import com.tg.cmd.patient.externalservices.ClinicServiceMockImpl;
import com.tg.cmd.patient.externalservices.DoctorServiceMockImpl;
import com.tg.cmd.patient.patientService.PatientService;
import com.tg.cmd.patient.validators.PatientValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patients")
public class PatientController {

    Logger log = LoggerFactory.getLogger(PatientApplication.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientValidator patientValidator;

    @Autowired
    private ClinicServiceMockImpl clinicServiceMockImpl;

    @Autowired
    private DoctorServiceMockImpl doctorServiceMockImpl;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseWrapper<String>> addPatient(@RequestBody PatientDTO patientDTO)
            throws PatientNotFoundException {

        if (patientDTO == null) {
            throw new IllegalArgumentException("Received information is null");
        }

        try {
            patientService.addPatient(patientDTO);
            log.info("Patient added successfully: {}", patientDTO.getFullName());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper<>("Patient added successfully"));

        } catch (Exception e) {
            log.error("An unexpected error occurred while adding patient: {}", patientDTO.getFullName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("An unexpected error occurred"));
        }
    }

    @GetMapping("/viewPatient/{patientId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ResponseWrapper<PatientDTO>> getPatientById(@PathVariable("patientId") String patientId) {
        log.info("Received request to view patient with ID: {}", patientId);

        try {
            PatientDTO patient = patientService.getPatientDetailsById(patientId);
            log.info("Fetched patient details successfully for patient ID: {}", patientId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("Patient details fetched successfully", patient));
        } catch (PatientNotFoundException e) {
            log.error("Patient not found with ID: {}", patientId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<>("Patient not found with ID: " + patientId));
        } catch (Exception e) {
            log.error("Unexpected error occurred while fetching patient details for ID: {}", patientId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("An unexpected error occurred"));
        }
    }

    @GetMapping("/viewPatientFamilyMembers/{patientId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ResponseWrapper<List<FamilyMemberDTO>>> getFamilyMembersByPatientId(
            @PathVariable("patientId") String patientId) throws FamilyMemberNotFoundException {
        log.info("Received request to view family members for patient with ID: {}", patientId);

        try {
            List<FamilyMemberDTO> familyMembers = patientService.getPatientFamilyMembers(patientId);
            log.info("Fetched family members successfully for patient ID: {}", patientId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("Family members fetched successfully", familyMembers));
        } catch (Exception e) {
            log.error("Unexpected error occurred while fetching family members for patient ID: {}", patientId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("An unexpected error occurred"));
        }
    }

    @GetMapping("/viewPatientAddresses/{patientId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ResponseWrapper<List<AddressDTO>>> getAddressesByPatientId(
            @PathVariable("patientId") String patientId) {
        log.info("Received request to view addresses for patient with ID: {}", patientId);

        try {
            List<AddressDTO> addresses = patientService.getPatientAddresses(patientId);
            log.info("Fetched addresses successfully for patient ID: {}", patientId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("Addresses fetched successfully", addresses));
        } catch (Exception e) {
            log.error("Unexpected error occurred while fetching addresses for patient ID: {}", patientId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("An unexpected error occurred"));
        }
    }

    @PutMapping("/{patientId}/{phone}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseWrapper<String>> updatePatient(@PathVariable("patientId") String patientId,
            @PathVariable("phone") String phone) throws PatientNotFoundException {
        log.info("Received request to update phone number for patient ID: {}", patientId);

        try {
            patientService.updatePatientPhone(patientId, phone);
            log.info("Patient updated successfully: {}", patientId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("Patient updated successfully"));
        } catch (Exception e) {
            log.error("Unexpected error occurred while updating patient: {}", patientId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("An unexpected error occurred"));
        }
    }

    @DeleteMapping("/{patientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseWrapper<String>> deletePatient(@PathVariable("patientId") String patientId)
            throws PatientNotFoundException {
        log.info("Received request to delete patient with ID: {}", patientId);

        boolean status = patientService.deletePatient(patientId);
        if (status) {
            log.info("Patient with ID {} deleted successfully", patientId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("Patient with ID " + patientId + " deleted successfully."));
        } else {
            log.error("Patient not found with ID: {}", patientId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseWrapper<>("Patient not found."));
        }
    }

    @GetMapping("/getAllPatients")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ResponseWrapper<List<PatientDTO>>> getAllPatients() {
        log.info("Received request to fetch all patients");

        try {
            List<PatientDTO> patients = patientService.getAllPatients();
            log.info("Fetched all patients successfully, total count: {}", patients.size());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("All patients fetched successfully", patients));
        } catch (Exception e) {
            log.error("Unexpected error occurred while fetching all patients", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>("An unexpected error occurred"));
        }
    }

}
