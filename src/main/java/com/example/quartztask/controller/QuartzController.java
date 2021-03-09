package com.example.quartztask.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.quartztask.service.QuartzService;

@RestController
@RequestMapping("/quartz")
public class QuartzController {
	
	
	@Autowired
	private QuartzService quartzService;
	
	@PostMapping("/demo/{name}")
	public String a(@PathVariable String name) throws SchedulerException {
		
		quartzService.demo(name);
		return "In running State Kindly Open Your Console.....";
	}

}
