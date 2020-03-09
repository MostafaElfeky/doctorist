package com.seniorsteps.doctorist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seniorsteps.doctorist.models.Doctor;
import com.seniorsteps.doctorist.repository.DoctorRepository;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DoctorRepositoryTest {

	
	private static Doctor doctor = getDumyDoctor();

	@Autowired
	private DoctorRepository doctorRepository;
	
	
	@Test
	@Order(1)
	public void testSaveDoctor() {
		
		doctor = doctorRepository.save(doctor);
		assertThat(doctor.getId()).isNotNull().isGreaterThan(0);
	}
	
	
	@Test
	@Order(2)
	public void testGetDoctor() {
		
		Doctor savedDoctor = doctorRepository.findDoctorById(doctor.getId());
		assertThat(savedDoctor).isNotNull();
	}
	
	@Test
	@Order(3)
	public void testListDoctor() {
		
		List<Doctor> doctors = doctorRepository.findAll();
		
		assertThat(doctors).isNotNull();
		assertThat(doctors.size()).isGreaterThanOrEqualTo(1);
	}
	
	
	@Test
	@Order(4)
	public void testUpdateDoctor() {
		
		String title = "update title";
		
		doctor.setTitle(title);
		Doctor updatedDoctor = doctorRepository.save(doctor);

		assertThat(updatedDoctor.getTitle()).isEqualTo(title);
	}
	
	@Test
	@Order(5)
	public void testDeleteDoctor() {
		
		
		doctorRepository.delete(doctor);
		Doctor deletedDoctor = doctorRepository.findDoctorById(doctor.getId());
		
		assertThat(deletedDoctor).isNull();
	}
	
	
	private static Doctor getDumyDoctor() {

		Doctor doctor = new Doctor();
		
		doctor.setFirstName("osman");
		doctor.setLastName("mohamed");
		doctor.setAbout("osman is a very successfull doctor");
		doctor.setTitle("doctor");
		
		return doctor;
	}
	
}
