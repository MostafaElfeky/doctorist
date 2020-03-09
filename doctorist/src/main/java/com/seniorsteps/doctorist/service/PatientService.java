package com.seniorsteps.doctorist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorsteps.doctorist.models.Patient;
import com.seniorsteps.doctorist.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public Patient register(Patient patient) {

		Patient savedPatient = patientRepository.save(patient);

		return savedPatient;
	}

	public List<Patient> list() {

		List<Patient> patients = patientRepository.findAll();

		return patients;
	}

	public Patient getPatient(Long patientId) {

		Patient patient = patientRepository.findById(patientId).get();
		return patient;
	}

}
