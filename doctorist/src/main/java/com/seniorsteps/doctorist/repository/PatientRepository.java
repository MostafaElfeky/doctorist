package com.seniorsteps.doctorist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seniorsteps.doctorist.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
