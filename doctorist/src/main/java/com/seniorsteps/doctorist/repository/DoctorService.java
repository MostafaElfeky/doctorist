package com.seniorsteps.doctorist.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorsteps.doctorist.models.Doctor;

@Service
public class DoctorService {

	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Transactional
	public List<Doctor> list() {
		
		List<Doctor> all = doctorRepository.findAll();
		
		return all;
	}
	
}
