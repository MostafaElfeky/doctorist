package com.seniorsteps.doctorist.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.doctorist.models.TimeSchedule;
import com.seniorsteps.doctorist.service.TimeScheduleService;



@RestController
@RequestMapping("/time-schedules")
public class TimeScheduleController {

	@Autowired
	private TimeScheduleService timeScheduleService;
	
	
	@PostMapping
	public TimeSchedule create(@RequestBody TimeSchedule timeSchedule) {
				
		return timeScheduleService.create(timeSchedule);
	}
	
}
