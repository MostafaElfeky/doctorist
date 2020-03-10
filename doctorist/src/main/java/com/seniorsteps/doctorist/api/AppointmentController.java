package com.seniorsteps.doctorist.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.doctorist.models.Appointment;
import com.seniorsteps.doctorist.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping
	public Appointment create(@RequestBody Appointment appointment) {
		
		return appointmentService.create(appointment);
	}
	
	@GetMapping("/free")
	public List<Appointment> getFreeApoitment() {
		
		List<Appointment> appointments = appointmentService.getFreeApointment();
		
		return appointments;
	}
	
	@PutMapping("/reserve")
	public Appointment reserveApoitment(
			@RequestParam(name="appointmentId") Long appointmentId,
			@RequestParam(name="patientId") Long patientId
			) {
				
		Appointment appointment = appointmentService.resrve(appointmentId, patientId);
		return appointment;
	}
	
}
