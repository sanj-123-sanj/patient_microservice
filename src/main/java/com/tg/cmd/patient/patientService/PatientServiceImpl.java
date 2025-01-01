package com.tg.cmd.patient.patientService;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.cmd.patient.PatientApplication;
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
import com.tg.cmd.patient.externalservices.ClinicServiceFactory;
import com.tg.cmd.patient.externalservices.DoctorServiceFactory;
import com.tg.cmd.patient.externalservices.IClinicService;
import com.tg.cmd.patient.externalservices.IDoctorService;
import com.tg.cmd.patient.mapper.PatientMapper;
import com.tg.cmd.patient.model.Patient;
import com.tg.cmd.patient.repositories.PatientRepository;
import com.tg.cmd.patient.validators.PatientValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientApplication.class);

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientValidator patientValidator;

    @Autowired
    
    private PatientMapper patientMapper;

    private IDoctorService doctorService;
    private IClinicService clinicService;

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) throws PatientAlreadyExistsException, InvalidNameException, InvalidPhoneNumberException, InvalidDateOfBirthException, InvalidGenderException, InvalidAddressException, InvalidFamilyMemberException {
        doctorService = DoctorServiceFactory.create("mock");
        clinicService = ClinicServiceFactory.create("mock");
        log.info("Adding new patient: {}", patientDTO.getFullName());

        patientValidator.validatePatientData(patientDTO);
        // Map DTO to Entity (including embedded Address and FamilyMember)
        Patient patient = patientMapper.toPatient(patientDTO);
        Patient savedPatient = patientRepository.save(patient);

        // Return the saved entity as a DTO
        return patientMapper.toPatientDTO(savedPatient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientDetailsById(String patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));
        return patientMapper.toPatientDTO(patient);
    }
    

    @Override
    public Patient updatePatientPhone(String patientId, String phone)
            throws PatientNotFoundException, InvalidPhoneNumberException {
        if (!patientValidator.isValidPhoneNumber(phone)) {
            throw new InvalidPhoneNumberException("Invalid phone number format.");
        }

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));
        patient.setPhoneNumber(phone);

        return patientRepository.save(patient);
    }

    @Override
    public boolean deletePatient(String patientId) {
        if (!patientRepository.existsById(patientId)) {
            return false;
        }
        patientRepository.deleteById(patientId);
        return true;
    }

    @Override
    public List<AddressDTO> getPatientAddresses(String patientId) throws AddressNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new AddressNotFoundException("No addresses found for patient with ID: " + patientId));

        // Return the list of AddressDTOs, assuming Address is embedded in Patient
        if (patient.getAddress() == null) {
            throw new AddressNotFoundException("No address found for patient with ID: " + patientId);
        }

        return List.of(patientMapper.toAddressDTO(patient.getAddress()));  // Mapping embedded Address to DTO
    }

    @Override
    public List<FamilyMemberDTO> getPatientFamilyMembers(String patientId) throws FamilyMemberNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new FamilyMemberNotFoundException("No family members found for patient with ID: " + patientId));

        // Ensure familyMember is not null
        if (patient.getFamilyMember() == null) {
            throw new FamilyMemberNotFoundException("No family members found for patient with ID: " + patientId);
        }

        // Return the FamilyMemberDTO as a single-item list, since familyMember is embedded and not a collection
        return List.of(patientMapper.toFamilyMemberDTO(patient.getFamilyMember()));
    }
}