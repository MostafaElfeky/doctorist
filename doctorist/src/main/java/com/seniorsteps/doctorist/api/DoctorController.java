package com.seniorsteps.doctorist.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.doctorist.filters.SearchFilter;
import com.seniorsteps.doctorist.models.Doctor;
import com.seniorsteps.doctorist.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@GetMapping
	public List<Doctor> list(SearchFilter filter) {
		
		List<Doctor> doctors = doctorService.list(filter);
		
		logger.debug("******* Going to list Doctors");
		
		return doctors;
	}
	
	@PostMapping
	public Doctor register(@RequestBody Doctor doctor) {
		
		return doctorService.register(doctor);
	}
	
	@GetMapping("/{doctorId}")
	public Doctor getDoctor(@PathVariable(name = "doctorId") Long doctorId) {
		
		return doctorService.getDoctor(doctorId);
	}
	
}
