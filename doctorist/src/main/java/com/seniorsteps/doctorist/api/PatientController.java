package com.seniorsteps.doctorist.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.doctorist.models.Patient;
import com.seniorsteps.doctorist.service.PatientService;


@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	
	@PostMapping
	public Patient register(@RequestBody Patient patient) {
		
		return patientService.register(patient);
	}
	
	@GetMapping
	public List<Patient> list() {
		
		List<Patient> patients = patientService.list();		
		return patients;
	}
	
	@GetMapping("/{patientId}")
	public Patient getDoctor(@PathVariable(name = "patientId") Long patientId) {
		
		Patient patient = patientService.getPatient(patientId);
		
		return patient;
	}
	
}
