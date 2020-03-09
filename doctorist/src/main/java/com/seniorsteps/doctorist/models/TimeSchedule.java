package com.seniorsteps.doctorist.models;



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
@Table(name = "TIME_SCHEDULE")
public class TimeSchedule {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "FROM_TIME")
	private LocalTime from;
	
	@Column(name = "TO_TIME")
	private LocalTime to;
	
	@Column(name = "APPOINTMENT_TIME")
	private Long appointmentTime;
	
	@Column(name = "DAY")
	private int day;
	
	@Column(name = "AUTOMATIC")
	private Boolean automatic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="DOCTOR_ID")
	private Doctor doctor;

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
	
	public Boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(Boolean automatic) {
		this.automatic = automatic;
	}

	@Override
	public String toString() {
		return "TimeSchedule [id=" + id + ", from=" + from + ", to=" + to + ", appointmentTime=" + appointmentTime
				+ ", day=" + day + ", automatic=" + automatic + ", doctor="
				+ doctor + "]";
	}
	

}
