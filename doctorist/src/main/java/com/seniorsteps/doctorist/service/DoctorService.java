package com.seniorsteps.doctorist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seniorsteps.doctorist.filters.SearchFilter;
import com.seniorsteps.doctorist.models.Doctor;
import com.seniorsteps.doctorist.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	public Doctor register(Doctor doctor) {

		return doctorRepository.save(doctor);
	}

	public List<Doctor> list(SearchFilter filter) {

		Page<Doctor> page = doctorRepository.findAllByFirstNameLike(filter.getKeyword(),
				PageRequest.of(filter.getStart(), 
						filter.getCount(), Sort.by("id").descending()));
		
		List<Doctor> doctors = page.getContent();

		return doctors;
	}

	public Doctor getDoctor(Long doctorId) {

		Doctor doctor = doctorRepository.findDoctorById(doctorId);

		return doctor;
	}

}
