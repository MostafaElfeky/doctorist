package com.seniorsteps.doctorist.models;



import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "APPOINTMENT")
public class Appointment {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "FROM_TIME")
	private LocalTime from;
	
	@Column(name = "TO_TIME")
	private LocalTime to;
	
	@Column(name = "APPOINTMENT_DATE")
	private LocalDate appointmentDate;
	
	@Column(name = "APPOINTMENT_TIME")
	private Long appointmentTime;
	
	@Column(name = "DAY")
	private int day;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID")
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getFrom() {
		return from;
	}

	public void setFrom(LocalTime from) {
		this.from = from;
	}

	public LocalTime getTo() {
		return to;
	}

	public void setTo(LocalTime to) {
		this.to = to;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Long getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Long appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", from=" + from + ", to=" + to + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", day=" + day + ", doctor=" + doctor + ", patient="
				+ patient + "]";
	}

	

}
