/*package com.tg.cmd.patient;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.tg.cmd.patient.controllers.PatientController;
import com.tg.cmd.patient.dto.patient.PatientDTO;
import com.tg.cmd.patient.dto.patient.ResponseWrapper;
import com.tg.cmd.patient.exceptions.PatientNotFoundException;
import com.tg.cmd.patient.externalservices.ClinicServiceImpl;
import com.tg.cmd.patient.externalservices.ClinicServiceMockImpl;
import com.tg.cmd.patient.externalservices.DoctorServiceMockImpl;
import com.tg.cmd.patient.patientService.PatientService;



class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientService patientService;

    @Mock
    private ClinicServiceMockImpl clinicServiceMockImpl;

    @Mock
    private DoctorServiceMockImpl doctorServiceMockImpl;
    
    @InjectMocks
    private ClinicServiceImpl clinicService;

   

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPatient_Success() throws Exception {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFullName("John Doe");

        when(patientService.addPatient(patientDTO)).thenReturn(patientDTO);

        ResponseEntity<ResponseWrapper<String>> response = patientController.addPatient(patientDTO);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Patient added successfully", response.getBody().getMessage());
        verify(patientService, times(1)).addPatient(patientDTO);
    }

    @Test
    void testGetPatientById_Success() throws Exception {
        String patientId = "PAT123";
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFullName("John Doe");

        when(patientService.getPatientDetailsById(patientId)).thenReturn(patientDTO);

        ResponseEntity<ResponseWrapper<PatientDTO>> response = patientController.getPatientById(patientId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Patient details fetched successfully", response.getBody().getMessage());
        assertEquals(patientDTO, response.getBody().getData());
        verify(patientService, times(1)).getPatientDetailsById(patientId);
    }

    @Test
    void testGetAllPatients_Success() throws Exception {
        List<PatientDTO> patients = Arrays.asList(new PatientDTO(), new PatientDTO());

        when(patientService.getAllPatients()).thenReturn(patients);

        ResponseEntity<ResponseWrapper<List<PatientDTO>>> response = patientController.getAllPatients();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("All patients fetched successfully", response.getBody().getMessage());
        assertEquals(patients, response.getBody().getData());
        verify(patientService, times(1)).getAllPatients();
    }

    @Test
    void testAddPatient_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> patientController.addPatient(null));
    }

    @Test
    void testGetPatientById_NotFound() throws Exception {
        String patientId = "SAT123";

        when(patientService.getPatientDetailsById(patientId)).thenThrow(new PatientNotFoundException("Patient not found"));

        ResponseEntity<ResponseWrapper<PatientDTO>> response = patientController.getPatientById(patientId);

        assertEquals(404, response.getStatusCodeValue());
        assertEquals("Patient not found with ID: " + patientId, response.getBody().getMessage());
        verify(patientService, times(1)).getPatientDetailsById(patientId);
    }

    @Test
    void testAddPatient_InvalidData() throws Exception {
        PatientDTO patientDTO = new PatientDTO();

        when(patientService.addPatient(patientDTO)).thenThrow(new IllegalArgumentException("Invalid patient data"));

        ResponseEntity<ResponseWrapper<String>> response = patientController.addPatient(patientDTO);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid patient data", response.getBody().getMessage());
        verify(patientService, times(1)).addPatient(patientDTO);
    }

    @Test
    void testGetPatientById_InvalidId() throws Exception {
        String patientId = "TYU*";

        when(patientService.getPatientDetailsById(patientId)).thenThrow(new IllegalArgumentException("Invalid patient ID"));

        ResponseEntity<ResponseWrapper<PatientDTO>> response = patientController.getPatientById(patientId);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid patient ID: " + patientId, response.getBody().getMessage());
        verify(patientService, times(1)).getPatientDetailsById(patientId);
    }

    @Test
    void testGetAllPatients_EmptyList() throws Exception {
        when(patientService.getAllPatients()).thenReturn(Arrays.asList());

        ResponseEntity<ResponseWrapper<List<PatientDTO>>> response = patientController.getAllPatients();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("All patients fetched successfully", response.getBody().getMessage());
        assertTrue(response.getBody().getData().isEmpty());
        verify(patientService, times(1)).getAllPatients();
    }

    @Test
    void testAddPatient_UnexpectedException() throws Exception {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFullName("John Doe");

        when(patientService.addPatient(patientDTO)).thenThrow(new RuntimeException("Unexpected error"));

        ResponseEntity<ResponseWrapper<String>> response = patientController.addPatient(patientDTO);

        assertEquals(500, response.getStatusCodeValue());
        assertEquals("An unexpected error occurred", response.getBody().getMessage());
        verify(patientService, times(1)).addPatient(patientDTO);
    }

    @Test
    void testAddPatient_ValidPhoneNumberAndName() throws Exception {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFullName("JohnDoe");
        patientDTO.setPhoneNumber("1234567890");

        when(patientService.addPatient(patientDTO)).thenReturn(patientDTO);

        ResponseEntity<ResponseWrapper<String>> response = patientController.addPatient(patientDTO);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Patient added successfully", response.getBody().getMessage());
        verify(patientService, times(1)).addPatient(patientDTO);
    }
    
    @Test
    void testAddPatient_NameTooLong() throws Exception {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFullName("John Doe".repeat(50)); // Exceeding character limit

        when(patientService.addPatient(patientDTO)).thenThrow(new IllegalArgumentException("Full name exceeds the character limit"));

        ResponseEntity<ResponseWrapper<String>> response = patientController.addPatient(patientDTO);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Full name exceeds the character limit", response.getBody().getMessage());
        verify(patientService, times(1)).addPatient(patientDTO);
    }





}*/

