package com.example.quartztask.model;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Demo implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		String name = (String) context.getMergedJobDataMap().getWrappedMap().get("name");
		System.out.println("Job schedular...!!!" + name + "...");
		
	
		System.out.println(new Date(System.currentTimeMillis()));
	}

}
