package com.example.quartztask.service;

import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import com.example.quartztask.model.QuartzModel;

@Service
public class QuartzService {
public void demo(String name) throws SchedulerException {
		
		QuartzModel.run(name);
		
}
}
