package com.tg.cmd.patient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.cmd.patient.model.Patient;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for interacting with the Patient entity in the database.
 * It extends JpaRepository to provide basic CRUD operations and custom query methods.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {



	boolean existsById(String patientId);

	void deleteById(String patientId);

	Optional<Patient> findById(String patientId);

	boolean existsByPhoneNumber(String phoneNumber);




}
