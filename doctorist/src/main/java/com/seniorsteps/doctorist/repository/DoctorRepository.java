package com.seniorsteps.doctorist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorsteps.doctorist.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Page<Doctor> findAllByFirstNameLike(String string, PageRequest of);

	Doctor findDoctorById(Long doctorId);
	
}
