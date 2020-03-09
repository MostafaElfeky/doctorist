package com.seniorsteps.doctorist.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.doctorist.models.Doctor;
import com.seniorsteps.doctorist.repository.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	DoctorService doctorRepository;
	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@GetMapping
	public List<Doctor> list() {
		
		List<Doctor> doctors = doctorRepository.list();
		
		logger.debug("******* Going to list Doctors");
		
		return doctors;
	}
	
}
