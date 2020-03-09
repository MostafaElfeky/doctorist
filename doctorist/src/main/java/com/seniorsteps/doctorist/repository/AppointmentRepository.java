package com.seniorsteps.doctorist.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.seniorsteps.doctorist.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@EntityGraph(value = "Appointment.details", type = EntityGraphType.FETCH)
	List<Appointment> findByPatientIdIsNull();

	@Modifying
	void deleteByAppointmentDate(LocalDate now);

}
