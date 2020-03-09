package com.seniorsteps.doctorist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seniorsteps.doctorist.models.TimeSchedule;

public interface TimeScheduleRepository extends JpaRepository<TimeSchedule, Long> {

}
