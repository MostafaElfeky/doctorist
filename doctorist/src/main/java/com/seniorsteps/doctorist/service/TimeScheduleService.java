package com.seniorsteps.doctorist.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorsteps.doctorist.models.TimeSchedule;
import com.seniorsteps.doctorist.repository.TimeScheduleRepository;


@Service
public class TimeScheduleService {

	@Autowired
	TimeScheduleRepository timeScheduleRepository;
	

	public TimeSchedule create(TimeSchedule timeSchedule) {
		
		TimeSchedule savedTimeSchedule = timeScheduleRepository.save(timeSchedule);
		
		return savedTimeSchedule;
	}
	
}
