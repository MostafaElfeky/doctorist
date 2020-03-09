package com.seniorsteps.doctorist.service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seniorsteps.doctorist.models.Appointment;
import com.seniorsteps.doctorist.models.Doctor;
import com.seniorsteps.doctorist.models.TimeSchedule;
import com.seniorsteps.doctorist.repository.AppointmentRepository;
import com.seniorsteps.doctorist.repository.DoctorRepository;


@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired 
	DoctorRepository doctorRepository;
	
	public Appointment create(Appointment appointment) {
		
		Appointment savedAppointment = appointmentRepository.save(appointment);
		 
		return savedAppointment;
	}
	
	public Appointment resrve(Long appointmentId, Long patientId) {
		
		Appointment appointment = appointmentRepository.getOne(appointmentId);
		
		if (appointment.getPatient() == null) {
			appointment.getPatient().setId(patientId);
			appointment = appointmentRepository.save(appointment);
		} else {
			throw new RuntimeException("Already reserved");
		}
		
		return appointment;
	}
	
	/**
	 * Get free appointment when no patient reserve this appointment
	 * */
	public List<Appointment> getFreeApointment() {

		List<Appointment> appointments = appointmentRepository.findByPatientIdIsNull();
		return appointments;
	}
	
	/**
	 * Create automatic appointment for each doctor depending on doctor time schedule configuration
	 * should run every day. 
	 * */
	@Transactional
	@Scheduled(fixedRate = 86400000) // Run every day(24H)
    public void create() {
		
		try {
			
	        List<Doctor> doctors = doctorRepository.findAll();
	        
	        if(doctors != null && !doctors.isEmpty())
	        	appointmentRepository.deleteByAppointmentDate(LocalDate.now());
	        
	        for(Doctor doctor : doctors) {
	        	if(doctor.getTimeSchedules() != null) {
	        		for(TimeSchedule timeSchedule : doctor.getTimeSchedules()) {
	        			if(timeSchedule.isAutomatic())
	        				saveTimeSchedulesAppointment(timeSchedule, doctor);
	        		}
	        	}
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * Split doctor time schedule into many appointments depending on time schedule configured period
	 * */
	private void saveTimeSchedulesAppointment(TimeSchedule timeSchedule, Doctor doctor) {
		
		while (timeSchedule.getFrom().isBefore(timeSchedule.getTo())) {

			Appointment appointment = new Appointment();
			
			appointment.setAppointmentDate(LocalDate.now());
			appointment.setAppointmentTime(timeSchedule.getAppointmentTime());
			
			appointment.setDay(timeSchedule.getDay());
			appointment.getDoctor().setId(doctor.getId());
			
			appointment.setFrom(timeSchedule.getFrom());
			appointment.setTo(timeSchedule.getFrom().plus(timeSchedule.getAppointmentTime(), ChronoUnit.MINUTES));
			timeSchedule.setFrom(timeSchedule.getFrom().plus(timeSchedule.getAppointmentTime(), ChronoUnit.MINUTES));

			appointmentRepository.save(appointment);
		}
		
	}
	
}
